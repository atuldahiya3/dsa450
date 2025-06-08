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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int leftHeight=diameterOfBinaryTree(root.left);
        int rightHeight=diameterOfBinaryTree(root.right);
        int maxHeight=height(root.left)+height(root.right);
        return Math.max(maxHeight, Math.max(leftHeight,rightHeight));
    }
    public int height(TreeNode root){
        if(root==null) return 0;
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        int maxHeight=Math.max(leftHeight,rightHeight)+1;
        return maxHeight;
    }
}