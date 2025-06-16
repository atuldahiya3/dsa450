/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    // Helper class to store a node with its row and column index
    static class NodeInfo {
        Node node;
        int row, col;

        NodeInfo(Node node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        // TreeMap to sort columns left to right, then rows top to bottom
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Queue for level-order traversal with node and its position
        Queue<NodeInfo> q = new LinkedList<>();
        q.offer(new NodeInfo(root, 0, 0)); // root at row 0, col 0

        while(!q.isEmpty()){
            NodeInfo currNode=q.poll();
            Node curr=currNode.node;
            int row=currNode.row;
            int col=currNode.col;
            
            if(!map.containsKey(col)) map.put(col,curr.data);
            if(curr.left!=null) q.offer(new NodeInfo(curr.left,row+1,col-1));
            if(curr.right!=null) q.offer(new NodeInfo(curr.right,row+1,col+1));
        }
        res.addAll(map.values());
        return res;
    }
}
