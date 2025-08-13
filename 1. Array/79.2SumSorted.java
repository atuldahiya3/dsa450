class Solution {
    public ArrayList<Integer> twoSum(int[] arr, int target) {
        // code here
        ArrayList<Integer> res= new ArrayList<>();
        int n=arr.length;
        int i=0,j=n-1;
        while(i<j){
            if(arr[i]+arr[j]==target){
                res.add(i+1);
                res.add(j+1);
                return res;
            }else if(arr[i]+arr[j]>target){
                j--;
            }else{
                i++;
            }
        }
        res.add(-1);
        res.add(-1);
        return res;
    }
    public ArrayList<Integer> twoSum2(int[] arr, int target) {
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