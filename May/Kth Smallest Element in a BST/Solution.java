/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[1];
        return traverse(root, k, result).val;

    }

    public TreeNode traverse(TreeNode curr, int k, int[] result) {
        if (curr == null)
            return null;
        // leftmost node first
        TreeNode left = traverse(curr.left, k, result);

        if (left != null)
            return left;
        result[0]++;
        if (result[0] == k)
            return curr;

        return traverse(curr.right, k, result);

    }
}