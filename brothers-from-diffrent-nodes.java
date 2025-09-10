/*Structure of the Node of the BST is as
class Node
{
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {

    public static boolean upper(List<Integer> l, int target) {

        int s = 0, e = l.size() - 1;

        while (s <= e) {

            Integer mid = s + (e - s) / 2;

            if (l.get(mid) == target) {

                return true;

            } else if (l.get(mid) > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }

        }

        return false;

    }

    public static void inorder(Node root, List<Integer> l) {

        if (root == null)
            return;

        inorder(root.left, l);

        l.add(root.data);

        inorder(root.right, l);

    }

    public static int countPairs(Node root1, Node root2, int x) {

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        inorder(root1, l1);
        inorder(root2, l2);

        int res = 0;

        for (Integer num : l1) {

            boolean found = upper(l2, x - num);
            if (found == false)
                continue;

            res += 1;
        }

        return res;
    }
}