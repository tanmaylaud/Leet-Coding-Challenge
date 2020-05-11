/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    class Pair {

        public TreeNode node;
        public int depth;
        public TreeNode parent;

        public Pair(TreeNode node, int depth, TreeNode parent) {
            this.node = node;
            this.depth = depth;
            this.parent = parent;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        int xDepth = 0;
        int yDepth = 0;

        Pair xPair = getNode(root, null, x, 0);
        Pair yPair = getNode(root, null, y, 0);

        if (xPair.depth == yPair.depth && xPair.parent != yPair.parent)
            return true;
        return false;
    }

    public Pair getNode(TreeNode node, TreeNode parent, int val, int depth) {
        if (node == null)
            return null;
        if (node.val == val)
            return new Pair(node, depth, parent);

        Pair pairL = getNode(node.left, node, val, depth + 1);
        Pair pairR = getNode(node.right, node, val, depth + 1);

        if (pairL == null)
            return pairR;
        return pairL;
    }
}