/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
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

    // Function to return a list of nodes visible from the top view
    static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<NodeInfo> q = new LinkedList<>();
        q.offer(new NodeInfo(root, 0, 0));

        while (!q.isEmpty()) {
            NodeInfo currNode = q.poll();
            Node curr = currNode.node;
            int row = currNode.row;
            int col = currNode.col;

            map.put(col, curr.data);
            
            if (curr.left != null)
                q.offer(new NodeInfo(curr.left, row + 1, col - 1));
            if (curr.right != null)
                q.offer(new NodeInfo(curr.right, row + 1, col + 1));
        }

        res.addAll(map.values());
        return res;
    }
}
