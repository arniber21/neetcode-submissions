/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = root.left != null ? maxDepth(root.left) : 0;
        int rightDepth = root.right != null ? maxDepth(root.right) : 0;
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }
}
