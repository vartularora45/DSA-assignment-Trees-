/*Structure of the node class is
class Node
{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
} */

class Solution {
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    void dfs(Node root, List<Integer> l) {

        if (root == null)
            return;

        l.add(root.data);

        dfs(root.left, l);
        dfs(root.right, l);

    }

    int i = 0;

    void inorder(Node root, List<Integer> l) {

        if (root == null)
            return;

        inorder(root.left, l);

        root.data = l.get(i);
        i++;

        inorder(root.right, l);

    }

    Node binaryTreeToBST(Node root) {
        // Your code here
        List<Integer> l = new ArrayList<>();

        dfs(root, l);

        Collections.sort(l);

        inorder(root, l);

        return root;
    }
}