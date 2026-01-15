class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int l=nums.length;
        int[] starting= new int[l];
        int[] ending= new int[l];
        List<Integer> res= new ArrayList<>();
        starting[0]=1;
        ending[l-1]=1;
        for(int i=1;i<l;i++){
            if(nums[i]<=nums[i-1]){
                starting[i]=starting[i-1]+1;
            }else{
                starting[i]=1;
            }
        }
        for(int i=l-2;i>=0;i--){
            if(nums[i]<=nums[i+1] ){
                ending[i]=ending[i+1]+1;
            }else{
                ending[i]=1;
            }
        }

        for(int i=k;i<l-k;i++){
            if(ending[i+1]>=k && starting[i-1]>=k) res.add(i);
        }
        return res;
    }
}