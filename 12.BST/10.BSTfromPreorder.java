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
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> s= new Stack<>();
        s.push(root);
        for(int i=1;i<preorder.length;i++){
            TreeNode node= new TreeNode(preorder[i]);
            if(preorder[i]<s.peek().val){
                s.peek().left=node;
            }else if(preorder[i]>s.peek().val){
                TreeNode parent=null;
                while(!s.isEmpty() && preorder[i]>s.peek().val){
                    parent=s.pop();
                }
                parent.right=node;
            }
            s.push(node);
        }
        return root;
    }
}