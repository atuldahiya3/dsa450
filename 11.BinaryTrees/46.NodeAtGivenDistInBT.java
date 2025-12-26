// class Node
// {
//     int data;
//     Node left, right;
// }

class Solution {
    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        // return the sorted list of all nodes at k dist
        HashMap<Node, Node> map= new HashMap<>();
        Queue<Node> q= new LinkedList<>();
        q.offer(root);
        Node targetNode = null;
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr.data==target){
                targetNode=curr;
            }
            if(curr.left!=null){
                q.offer(curr.left);
                map.put(curr.left,curr);
            }
            if(curr.right!=null){
                q.offer(curr.right);
                map.put(curr.right,curr);
            }
        }
        q.offer(targetNode);
        int count=0;
        HashSet<Node> visited = new HashSet<>();
        visited.add(targetNode);
        while(!q.isEmpty() && count<k){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node curr= q.poll();
                if(curr.left!=null && visited.add(curr.left)) q.offer(curr.left);
                if(curr.right!=null && visited.add(curr.right)) q.offer(curr.right);
                if(map.get(curr)!=null && visited.add(map.get(curr))) q.offer(map.get(curr));
            }
            count++;
        }
        ArrayList<Integer> res= new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().data);
        }
        Collections.sort(res);
        return res;
    }
};