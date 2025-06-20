public class Solution {
    static List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res.clear(); 
        List<Integer> pairs= new ArrayList<>();
        findPairs(candidates,0,target,pairs);
        return res;
    }
    public static void findPairs(int[] candidates, int index, int target, List<Integer> pairs){
        if (target == 0) {
            res.add(new ArrayList<>(pairs));
            return;
        }

        if (index >= candidates.length || target < 0) {
            return;
        }
        pairs.add(candidates[index]);
        findPairs(candidates,index,target-candidates[index],pairs);
        pairs.remove(pairs.size()-1);

        findPairs(candidates,index+1,target,pairs);
    }
} {
    
}
