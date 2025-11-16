class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        helper(nums,res,new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    public void helper(int[] nums, List<List<Integer>> res,List<Integer> temp, boolean[] used){
        if(nums.length==temp.size() ){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (used[j]) continue;

            used[j] = true;
            temp.add(nums[j]);
            helper(nums, res, temp, used);
            used[j] = false;
            temp.remove(temp.size() - 1);
        }
    }
}