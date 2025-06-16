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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null) return res;
        q.add(root);
        int count=1;
        while(!q.isEmpty()){
            int levelSize=q.size();
            List<Integer> list= new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode currNode=q.poll();
                list.add(currNode.val);
                if(currNode.left!=null) q.offer(currNode.left);    
                if(currNode.right!=null) q.offer(currNode.right); 
            }
            if(count%2!=0){
                res.add(list);
            }else{
                res.add(reverse(list));
            }
            count++;
               
        }
        return res;
    }
    public static List<Integer> reverse(List<Integer> list) {
    int left = 0, right = list.size() - 1;
    while (left < right) {
        int temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
        left++;
        right--;
    }
    return list;
}
}