class Solution69 {
    public int smallestDivisor(int[] nums, int threshold) {
        int min=1;
        int max=maximum(nums);
        int res=max;
        while(min<=max){
            int mid=min+(max-min)/2;
            if(checkThreshold(nums,mid,threshold)){
                res=mid;
                max=mid-1;
            }else{
                min=mid+1;
            }
        }
        return res;
    }
    public int maximum(int[] nums){
        int ans=Integer.MIN_VALUE;
        for(int num: nums){
            ans=Math.max(ans,num);
        }
        return ans;
    }
    public boolean checkThreshold(int[] nums, int mid, int threshold){
        int ans=0;
        for(int num: nums){
            ans+= (num+mid-1)/mid;
        }
        return ans<=threshold;
    }
}