/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    boolean search(Node root, int target) {

        if (root == null)
            return false;

        if (root.data == target)
            return true;

        if (root.data > target) {

            if (search(root.left, target))
                return true;

        }

        return search(root.right, target);
    }

    public boolean isDeadEnd(Node root) {

        if (root == null)
            return false;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            Node cur = q.poll();

            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);

            if (cur.left == null && cur.right == null) {

                if (cur.data == 1) {

                    if (search(root, 2))
                        return true;

                }

                else {

                    if (search(root, cur.data - 1) && search(root, cur.data + 1))
                        return true;

                }

            }

        }

        return false;
    }
}