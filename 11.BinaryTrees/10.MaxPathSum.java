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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findSum(root);
        return maxSum;
    }
    public int findSum(TreeNode root){
        if(root==null) return 0;

        int leftSum=Math.max(findSum(root.left),0);
        int rightSum=Math.max(findSum(root.right),0);

        int newPath=root.val+leftSum+rightSum;
        maxSum=Math.max(maxSum,newPath);
        return root.val+Math.max(leftSum,rightSum);
    }
}