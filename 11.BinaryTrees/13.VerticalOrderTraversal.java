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
    class NodeInfo{
        TreeNode node;
        int row, col;
        NodeInfo(TreeNode node, int row, int col){
            this.node=node;
            this.col=col;
            this.row=row;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map= new TreeMap<>();
        Queue<NodeInfo> q= new LinkedList<>();
        q.offer(new NodeInfo(root,0,0));
        while(!q.isEmpty()){
            NodeInfo info= q.poll();
            TreeNode node=info.node;
            int row=info.row;
            int col=info.col;

            map.putIfAbsent(col,new TreeMap<>());
            map.get(col).putIfAbsent(row,new PriorityQueue<Integer>());
            map.get(col).get(row).offer(node.val);

            if(node.left!=null) q.offer(new NodeInfo(node.left,row+1,col-1));
            if(node.right!=null) q.offer(new NodeInfo(node.right,row+1,col+1));
        }
        List<List<Integer>> res= new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> rowMap : map.values()){
            List<Integer> temp= new ArrayList<>();
            for(PriorityQueue<Integer> row:rowMap.values()){
                while(!row.isEmpty()){
                    temp.add(row.poll());
                }
            }
            res.add(temp);
        }
        return res;
    }
}