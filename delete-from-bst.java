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
    int minVal = -1;

    public TreeNode getMin(TreeNode root) {

        if (root.left == null) {
            minVal = root.val;
            if (root.right != null)
                return root.right;
            return null;
        }

        root.left = getMin(root.left);

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        // find key
        // check if no child then return null
        // if only one child then return that child
        // if two children then find the minimum the right sub-tree and return that node
        // after assigning the left child of key to that node and return.
        if (root.val == key) {

            if (root.left == null && root.right == null)
                return null;
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {

                // find the min node in right subtree.

                root.right = getMin(root.right);
                root.val = minVal;
                return root;

            }
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }

        else
            root.right = deleteNode(root.right, key);

        return root;

    }
}