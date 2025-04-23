class Solution23 {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        Node tail=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        
        while(head.next!=tail){
            ArrayList<Integer> temp=new ArrayList<>();
            if(head.data+tail.data==target){
                temp.add(head.data);
                temp.add(tail.data);
                res.add(temp);
                head=head.next;
            }else if(head.data+tail.data <= target){
                head=head.next;
            }else if(tail.data+head.data >=target){
                tail=tail.prev;
            }else{
                tail=tail.prev;
            }
        }
        if(head.data+tail.data==target){
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(head.data);
            temp.add(tail.data);
            res.add(temp);
        }
        return res;
    }
}