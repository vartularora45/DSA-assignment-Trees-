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

    int count = 0;

    void RangeCount(Node root, int l, int h) {

        if (root == null)
            return;

        if (root.data >= l && root.data <= h) {

            count++;
            RangeCount(root.left, l, h);
            RangeCount(root.right, l, h);

        } else if (root.data < l) {

            RangeCount(root.right, l, h);
        } else {
            RangeCount(root.left, l, h);
        }
    }

    int getCount(Node root, int l, int h) {

        RangeCount(root, l, h);
        return count;
    }

}