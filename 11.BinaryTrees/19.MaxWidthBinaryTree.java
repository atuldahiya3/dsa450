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
    static class NodeInfo{
        TreeNode node;
        int idx;
        NodeInfo(TreeNode node, int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<NodeInfo> q= new LinkedList<>();
        int maxWidth=0;
        q.offer(new NodeInfo(root,0));

        while(!q.isEmpty()){
            int currSize=q.size();
            int startIdx=q.peek().idx;
            int endIdx = ((LinkedList<NodeInfo>) q).getLast().idx;

            maxWidth=Math.max(maxWidth,endIdx-startIdx+1);
            for(int i=0;i<currSize;i++){
                NodeInfo currNode=q.poll();
                TreeNode curr=currNode.node;
                int currIndex=currNode.idx;
                if(curr.left!=null) q.offer(new NodeInfo(curr.left, 2*currIndex+1));
                if(curr.right!=null) q.offer(new NodeInfo(curr.right, 2*currIndex+2));
            }
        }
        return maxWidth;
    }
}