class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        helper(0, candidates, target, new ArrayList<>(), res, 0);
        return res;
    }
    public void helper(int i, int[] candidates, int target, List<Integer> temp, List<List<Integer>> res, int sum){
        if(sum==target){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(i==candidates.length || sum > target){
            return;
        }
        temp.add(candidates[i]);
        helper(i, candidates, target, temp,res, sum+candidates[i]);
        temp.remove(temp.size()-1);
        helper(i+1,candidates,target,temp,res,sum);
    }
}