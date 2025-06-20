class Solution {
    static List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res.clear();
        Arrays.sort(candidates);
        List<Integer> pairs= new ArrayList<>();
        findPiars(candidates, target, 0, pairs);
        return res;
    }
    public static void findPiars(int[] candidates, int target, int index, List<Integer> pairs){
        if(target==0){
            res.add(new ArrayList(pairs));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
            pairs.add(candidates[i]);
            findPiars(candidates, target-candidates[i], i+1, pairs);
            pairs.remove(pairs.size()-1);
        }
    }
}