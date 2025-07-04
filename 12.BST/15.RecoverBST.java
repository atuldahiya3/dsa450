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
    TreeNode first=null, second=null, prev=new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        swapNodes(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    public void swapNodes(TreeNode root){
        if(root==null) return;
        swapNodes(root.left);
        if(prev.val>root.val){
            if(first==null){
                first=prev;
            }
            second=root;
        }
        root=prev;
        swapNodes(root.right);
    }
}