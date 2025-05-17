import java.util.ArrayList;
import java.util.List;

class Solution6 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        backtracking(nums, 0, new ArrayList<>(), result);
        return result;

    }
    public void backtracking(int[] nums, int index, List<Integer> current, List<List<Integer>> result){
        result.add(new ArrayList<>(current));
        for(int i=index; i<nums.length;i++){
            current.add(nums[i]);
            backtracking(nums, i+1, current, result);
            current.remove(current.size()-1);
        }
    }
}