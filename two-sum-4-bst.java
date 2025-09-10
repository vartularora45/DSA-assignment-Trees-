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
    boolean inorder(TreeNode root, HashSet<Integer> set, int k) {

        if (root == null)
            return false;

        if (set.contains(k - root.val))
            return true;

        set.add(root.val);

        if (inorder(root.left, set, k))
            return true;

        return inorder(root.right, set, k);

    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();

        return inorder(root, set, k);
    }
}