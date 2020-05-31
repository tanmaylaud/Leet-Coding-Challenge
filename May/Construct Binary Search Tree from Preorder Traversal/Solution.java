/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {

        TreeNode root = new TreeNode(preorder[0], null, null);
        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }
        return root;
    }

    public void insert(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        TreeNode curr = root;
        TreeNode prev = root;
        while (curr != null) {
            prev = curr;
            if (val < curr.val) {
                curr = curr.left;
            } else
                curr = curr.right;

        }

        if (val < prev.val) {
            prev.left = newNode;
        } else
            prev.right = newNode;

    }
}