import java.util.LinkedList;
import java.util.Queue;

class basics{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode= new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }
    }
    public static void preorder(Node root){  
        if(root==null){
            // System.out.print("-1 ");
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void postorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void levelOrder(Node root){
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode=q.poll();
            if(currNode==null){
                System.out.println("");
                if(!q.isEmpty()){
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null) q.add(currNode.left);
                if(currNode.right!=null) q.add(currNode.right);
            }
        }
    }
    public static int countNodes(Node root){
        if(root==null) return 0;
        int leftNode=countNodes(root.left);
        int rightNode=countNodes(root.right);
        return leftNode+rightNode+1;
    }
    public static int sumNodes(Node root){
        if(root==null) return 0;
        int leftNode=countNodes(root.left);
        int rightNode=countNodes(root.right);
        return leftNode+rightNode+1;
    }
    public static void main(String[] args){
        int[] data={1, 2, 4, -1,-1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree=new BinaryTree();
        Node root= tree.buildTree(data);
        System.out.println("Binary Tree created with root value: " + root.data);
        // preorder(root);
        // inorder(root);
        // postorder(root);
        levelOrder(root);
        System.out.println("Total number of nodes in the tree: " + countNodes(root));
    }
    
}