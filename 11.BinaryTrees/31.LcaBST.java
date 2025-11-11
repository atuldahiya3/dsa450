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
    public Node LCA(Node root, Node n1, Node n2) {
        // code here
        ArrayList<Node> path1= new ArrayList<>();
        ArrayList<Node> path2= new ArrayList<>();
        findPath(root,path1,n1);
        findPath(root,path2,n2);
        Node prev=null;
        for(int i=0;i<Math.min(path1.size(),path2.size());i++){
            if(path1.get(i).data!=path2.get(i).data){
                return prev;
            }
            prev=path1.get(i);
        }
        return prev;
    }
    boolean findPath(Node root, ArrayList<Node> arr, Node target){
        if(root==null) return false;
        arr.add(root);
        
        if(root.data==target.data) return true;
        if(target.data>root.data){
            if(findPath(root.right,arr,target)){
                return true;
            }
        }else{
            if(findPath(root.left,arr,target)){
                return true;
            }
        }
        arr.remove(arr.size()-1);
        return false;
    }
}