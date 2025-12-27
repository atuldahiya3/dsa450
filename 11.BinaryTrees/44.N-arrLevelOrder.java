
import java.util.List;


class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res= new ArrayList<>();
        if(root==null) return res;
        Queue<Node> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> currLevel=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                currLevel.add(curr.val);
                for(Node n: curr.children){
                    q.offer(n);
                }
            }
            res.add(currLevel);
        }
        return res;
    }
}