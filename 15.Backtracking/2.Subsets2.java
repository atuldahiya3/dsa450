class Solution {
    static Set<List<Integer>> tempRes;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        tempRes= new HashSet<>();
        Arrays.sort(nums);
        List<Integer> temp= new ArrayList<>();
        helper(0,nums,temp);
        List<List<Integer>> res= new ArrayList<>(tempRes);
        // Collections.sort(res);
        return res;
    }
    public void helper(int i, int[] nums,List<Integer> temp){
        if(i>=nums.length){
            Collections.sort(temp);
            tempRes.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        helper(i+1,nums,temp);
        temp.remove(temp.size()-1);
        helper(i+1,nums,temp);
    }
}