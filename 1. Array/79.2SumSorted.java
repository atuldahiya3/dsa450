class Solution {
    public ArrayList<Integer> twoSum(int[] arr, int target) {
        // code here
        ArrayList<Integer> res= new ArrayList<>();
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(target-arr[i])){
                res.add(map.get(target-arr[i]));
                res.add(i+1);
                return res;
            }
            map.put(arr[i],i+1);
        }
        res.add(-1);
        res.add(-1);
        return res;
    }
}