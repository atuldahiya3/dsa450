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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        if(root.val==x || root.val==y) return false;
        while(!q.isEmpty()){
            boolean foundX=false;
            boolean foundY=false;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && curr.right!=null){
if((curr.left.val==x && curr.right.val==y) || (curr.left.val==y && curr.right.val==x)) return false;
                }
                
                if(curr.left!=null){
                    if(curr.left.val==x) foundX=true;
                    if(curr.left.val==y) foundY=true;
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    if(curr.right.val==x) foundX=true;
                    if(curr.right.val==y) foundY=true;
                    q.offer(curr.right);
                }
                if(foundX && foundY) return true;
            }
            if((foundX && !foundY) || (!foundX && foundY)) return false;
        }
        return false;
    }
}