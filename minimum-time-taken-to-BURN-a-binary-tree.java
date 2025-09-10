/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
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

    public int amountOfTime(TreeNode root, int start) {

        HashMap<TreeNode, List<TreeNode>> adjList = new HashMap<>();

        TreeNode startNode = null;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            int curLevelSize = q.size();

            while (curLevelSize > 0) {

                TreeNode curNode = q.poll();

                adjList.putIfAbsent(curNode, new ArrayList<>());

                if (curNode.val == start)
                    startNode = curNode;

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

        HashSet<TreeNode> vis = new HashSet<>();
        Queue<Pair<TreeNode, Integer>> bfsQueue = new LinkedList<>();

        int ans = 0;

        bfsQueue.add(new Pair(startNode, 0));
        vis.add(startNode);

        while (!bfsQueue.isEmpty()) {

            int curLevelSize = bfsQueue.size();

            while (curLevelSize > 0) {

                Pair<TreeNode, Integer> P = bfsQueue.poll();

                TreeNode curNode = P.first;
                int d = P.second;

                ans = Math.max(ans, d);

                if (curNode != null) {

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

        return ans;

    }
}