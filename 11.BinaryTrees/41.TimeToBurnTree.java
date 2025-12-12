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
    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        TreeNode target=null;
        Map<TreeNode, TreeNode> map= new HashMap<>();
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.val==start){
                    target=curr;
                }
                if(curr.left!=null){
                    map.put(curr.left, curr);
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    map.put(curr.right,curr);
                    q.offer(curr.right);
                }
            }
        }
        System.out.println(target.val);
        q.offer(target);
        Map<TreeNode, Boolean> visited= new HashMap<>();
        visited.put(target,true);
        int time=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(map.get(curr)!=null && visited.get(map.get(curr))==null){
                    q.offer(map.get(curr));
                    visited.put(map.get(curr),true);
                }
            }
            time++;
        }
        return time-1;
    }
}