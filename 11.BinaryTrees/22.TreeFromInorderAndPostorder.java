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
    int postOrderIndex=0;
    Map<Integer,Integer> inOrderMap= new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }
        return built(postorder,0,postorder.length-1);
    }
    public TreeNode built(int[] postorder, int left, int right){
        if(left>right) return null;
        int rootVal=postorder[postOrderIndex--];
        TreeNode root=new TreeNode(rootVal);

        root.right=built(postorder,inOrderMap.get(rootVal)+1,right);
        root.left=built(postorder,left,inOrderMap.get(rootVal)-1);
        return root;
    }
}