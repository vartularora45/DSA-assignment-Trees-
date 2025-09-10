/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

*/
class Solution {

    public void inorder(Node root, List<Integer> tree2) {

        if (root == null)
            return;

        inorder(root.left, tree2);

        tree2.add(root.data);

        inorder(root.right, tree2);

    }

    public ArrayList<Integer> merge(Node root1, Node root2) {

        List<Integer> inorder1 = new ArrayList<>();

        inorder(root2, inorder1);

        List<Integer> inorder2 = new ArrayList<>();

        inorder(root1, inorder2);

        ArrayList<Integer> res = new ArrayList<>();

        int i = 0, j = 0;

        int n = inorder1.size(), m = inorder2.size();

        while (i < n && j < m) {

            if (inorder1.get(i) <= inorder2.get(j)) {
                res.add(inorder1.get(i));
                i++;
            } else {
                res.add(inorder2.get(j));
                j++;
            }

        }

        while (i < n) {
            res.add(inorder1.get(i));
            i++;
        }

        while (j < m) {
            res.add(inorder2.get(j));
            j++;
        }

        return res;

    }
}