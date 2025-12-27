class Solution {
    int minDepth(Node root) {
        // code here
        int depth=1;
        Queue<Node> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                if(curr.left==null && curr.right==null) return depth;
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            depth++;
        }
        return depth;
    }
}