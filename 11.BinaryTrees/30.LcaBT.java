/*
class Node {
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class Solution {
    Node lca(Node root, int n1, int n2) {
        // code here
        ArrayList<Node> path1= new ArrayList<>();
        ArrayList<Node> path2= new ArrayList<>();
        findPath(root,path1,n1);
        findPath(root,path2,n2);
        Node prev=null;
        int n=Math.min(path1.size(),path2.size());
        // for(int i=0;i<path1.size();i++){
        //     System.out.println(path1.get(i).data);
        // }
        // for(int i=0;i<path2.size();i++){
        //     System.out.println(path2.get(i).data);
        // }
        for(int i=0;i<Math.min(path1.size(),path2.size());i++){
            if(path1.get(i).data!=path2.get(i).data){
                return prev;
            }
            prev=path1.get(i);
        }
        return prev;
    }
    boolean findPath(Node root, ArrayList<Node> arr, int target){
        if(root==null) return false;
        arr.add(root);
        if(root.data==target) return true;
        if(findPath(root.left,arr,target) || findPath(root.right,arr,target)){
            return true;
        }
        arr.remove(arr.size()-1);
        return false;
    }
}