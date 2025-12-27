
class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
        ArrayList<Integer> res= new ArrayList<>();
        Queue<Node> q= new LinkedList<>();
        q.offer(root);
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> temp= new ArrayList<>();
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                temp.add(curr.data);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            if(level%2==0){
                for(int i=temp.size()-1;i>=0;i--){
                    res.add(temp.get(i));
                }
            }else{
                for(int i=0;i<temp.size();i++){
                    res.add(temp.get(i));
                }
            }
            level++;
        }
        return res;
    }
}