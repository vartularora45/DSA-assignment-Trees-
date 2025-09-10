class Solution {
    // Function to find the nodes that are common in both BST.
    public static void inorder(Node root, HashSet<Integer> st) {

        if (root == null)
            return;

        st.add(root.data);

        inorder(root.left, st);
        inorder(root.right, st);

    }

    public static void getCommonElements(Node root, HashSet<Integer> st, ArrayList<Integer> res) {

        if (root == null)
            return;

        if (st.contains(root.data)) {

            res.add(root.data);

        }

        getCommonElements(root.left, st, res);
        getCommonElements(root.right, st, res);

    }

    public static ArrayList<Integer> findCommon(Node r1, Node r2) {

        ArrayList<Integer> res = new ArrayList<>();

        HashSet<Integer> st = new HashSet<>();

        inorder(r1, st);

        getCommonElements(r2, st, res);

        Collections.sort(res);

        return res;

    }
}