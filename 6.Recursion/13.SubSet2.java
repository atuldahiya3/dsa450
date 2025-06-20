class Solution {
    static List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res.clear();
        List<Integer> pairs= new ArrayList<>();
        Arrays.sort(nums);
        findPairs(nums, 0, pairs);
        return res;

    }
    public static void findPairs(int[] nums, int index, List<Integer> pairs){
        res.add(new ArrayList<>(pairs));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            pairs.add(nums[i]);
            findPairs(nums, i+1, pairs);
            pairs.remove(pairs.size()-1);
        }
    }
}