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

    public class Pair<U, V> {
        public U first;
        public V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;

        Queue<Pair<TreeNode, Integer>> q = new LinkedList();

        q.add(new Pair<>(root, 1));

        int width = 0;

        while (!q.isEmpty()) {

            int curSize = q.size();

            int firstIdx = -1, secondIdx = -1;

            while (curSize > 0) {

                Pair<TreeNode, Integer> p = q.poll();

                int leftIdx = p.second * 2;
                int rightIdx = p.second * 2 + 1;
                TreeNode curNode = p.first;

                if (firstIdx == -1) {
                    firstIdx = p.second;
                }

                if (curSize == 1) {
                    secondIdx = p.second;
                }

                if (curNode.left != null) {
                    q.add(new Pair<>(curNode.left, leftIdx));
                }
                if (curNode.right != null) {
                    q.add(new Pair<>(curNode.right, rightIdx));
                }

                curSize--;
            }

            width = Math.max(width, secondIdx - firstIdx + 1);
        }

        return width;
    }
}