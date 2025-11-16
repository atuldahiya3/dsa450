class Solution {
    static HashSet<ArrayList<Integer>> resSet;
    public ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int target) {
        // code here
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        Arrays.sort(arr);
        resSet= new HashSet<>();
        helper(0,arr,target,res, new ArrayList<>(),0);
        return new ArrayList<>(resSet);
    }
    public void helper(int i, int[] arr, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int sum){
        if(sum==target){
            resSet.add(new ArrayList<>(temp));
            return;
        }
        if(i==arr.length || sum>target){
            return;
        }
        temp.add(arr[i]);
        helper(i+1,arr,target,res,temp,sum+arr[i]);
        temp.remove(temp.size()-1);
        helper(i+1,arr,target,res,temp,sum);
    }
    
}