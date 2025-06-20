class Solution {
    static List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        res.clear();
        int[] nums={1,2,3,4,5,6,7,8,9};
        findPairs(nums, 0, 0, n, k, new ArrayList<>());
        return res;
    }
    public static void findPairs(int[] nums, int sum, int index, int target, int size, List<Integer> pairs){
        if(sum==target && size==pairs.size()){
            res.add(new ArrayList<>(pairs));
            return;
        }
        if(sum>target || pairs.size()>size) return;
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            pairs.add(nums[i]);
            sum+=nums[i];
            findPairs(nums, sum, i+1, target, size, pairs);
            pairs.remove(pairs.size()-1);
            sum-=nums[i];
        }
    }
}