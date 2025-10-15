class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        // HashMap<Integer, Integer> map= new HashMap<>();
        int[] arr= new int[101];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]++;
            // map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=k){
                if(arr[i]%k==0){
                    sum+=i*arr[i];
                }
            }
        }
        // for(int key: map.keySet()){
        //     if(map.get(key)%k==0){
        //         sum+=map.get(key)*key;
        //     }
        // }
        return sum;
    }
}