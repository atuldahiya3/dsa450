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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res= new ArrayList<>();
        solve(root,res);
        return res;
    }
    public void solve(TreeNode root, ArrayList<Integer> res){
        if(root==null) return;
        solve(root.left,res);
        solve(root.right,res);
        res.add(root.val);
    }
}