import java.util.*;

class Tree {
    public void dfs(int i, Node root, ArrayList<Node> t) {
        if (root == null) {
            while (i < t.size()) {
                if (t.get(i).left != null) {
                    dfs(i + 1, t.get(i).left, t);
                    return;
                }
                i++;
            }
            return;
        }

        t.add(root);
        dfs(i, root.right, t);
    }

    public ArrayList<Integer> diagonal(Node root) {
        ArrayList<Node> t = new ArrayList<>();
        dfs(0, root, t);

        ArrayList<Integer> result = new ArrayList<>();
        for (Node node : t) {
            result.add(node.data);
        }

        return result;
    }
}