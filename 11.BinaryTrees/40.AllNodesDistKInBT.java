/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map= new HashMap<>();
        Queue<TreeNode> q= new LinkedList<>();
        List<Integer> res= new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr= q.poll();
                if(curr.left!=null){
                    map.put(curr.left,curr);
                    q.offer(curr.left);

                }
                if(curr.right!=null){
                    map.put(curr.right,curr);
                    q.offer(curr.right);
                }
            }
        }
        q.offer(target);
        Map<TreeNode, Boolean> visited= new HashMap<>();
        int level=0;
        visited.put(target,true);
        while(!q.isEmpty() && k>0){
            System.out.println(k);
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
            k--;
        }
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            res.add(curr.val);
        }
        return res;
    }
}