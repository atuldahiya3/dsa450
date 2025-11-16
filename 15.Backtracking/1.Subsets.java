class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        // code here
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        ArrayList<Integer> temp= new ArrayList<>();
        helper(0, arr, res, temp);
        return res;
    }
    public void helper(int i, int arr[], ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp){
        if(i>=arr.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr[i]);
        helper(i+1,arr,res,temp);
        temp.remove(temp.size()-1);
        helper(i+1,arr,res,temp);
    }
}