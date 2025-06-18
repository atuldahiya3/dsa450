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
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> temp= new ArrayList<>();
        getPreorder(root,temp);
        TreeNode tempRoot=root;
        for(int i=1;i<temp.size();i++){
            tempRoot.left=null;
            tempRoot.right=temp.get(i);
            tempRoot=tempRoot.right;
        }
    }
    public void getPreorder(TreeNode root, ArrayList<TreeNode> temp){
        if(root==null) return;
        temp.add(root);
        getPreorder(root.left,temp);
        getPreorder(root.right,temp);
    }
}