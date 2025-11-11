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
    public int goodNodes(TreeNode root) {
        int maxSoFar=root.val;
        return dfs(root,maxSoFar);
    }
    public int dfs(TreeNode root, int maxSoFar){
        if(root==null) return 0;
        int count=0;
        if(root.val>=maxSoFar){
            count=1;
        }
        int newMax=Math.max(maxSoFar,root.val);
        count+=dfs(root.left,newMax);
        count+=dfs(root.right,newMax);
        return count;
    }
}