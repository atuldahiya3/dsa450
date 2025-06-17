// User function Template for Java

class Sol {
    // Function to return the floor of given number in BST.
    int floor(Node root, int key) {
        // code here.
        int floor=-1;
        while(root!=null){
            if(root.data>key){
                root=root.left;
            }else{
                floor=root.data;
                root=root.right;
            }
        }
        return floor;
    }
}
