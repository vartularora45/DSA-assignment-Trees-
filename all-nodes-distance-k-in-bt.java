/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    class Pair<U, V> {

        public U first;
        public V second;

        Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        HashMap<TreeNode, List<TreeNode>> adjList = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            int curLevelSize = q.size();

            while (curLevelSize > 0) {

                TreeNode curNode = q.poll();

                adjList.putIfAbsent(curNode, new ArrayList<>());

                if (curNode.left != null) {

                    adjList.putIfAbsent(curNode.left, new ArrayList<>());

                    adjList.get(curNode).add(curNode.left);
                    adjList.get(curNode.left).add(curNode);

                    q.add(curNode.left);
                }

                if (curNode.right != null) {

                    adjList.putIfAbsent(curNode.right, new ArrayList<>());

                    adjList.get(curNode).add(curNode.right);
                    adjList.get(curNode.right).add(curNode);

                    q.add(curNode.right);
                }

                curLevelSize--;

            }

        }

        List<Integer> res = new ArrayList<>();

        Queue<Pair<TreeNode, Integer>> bfsQueue = new LinkedList<>();

        bfsQueue.add(new Pair(target, 0));

        HashSet<TreeNode> vis = new HashSet<>();
        vis.add(target);

        while (!bfsQueue.isEmpty()) {

            int curLevelSize = bfsQueue.size();

            while (curLevelSize > 0) {

                Pair<TreeNode, Integer> P = bfsQueue.poll();

                TreeNode curNode = P.first;
                int d = P.second;

                if (d == k)
                    res.add(curNode.val);

                if (d < k) {

                    for (TreeNode adjNode : adjList.get(curNode)) {

                        if (!vis.contains(adjNode)) {

                            vis.add(adjNode);
                            bfsQueue.add(new Pair(adjNode, d + 1));

                        }

                    }

                }

                curLevelSize--;
            }
        }

        return res;

    }
}