class Solution73 {
    public int splitArray(int[] nums, int k) {
        int min=maximum(nums);
        int max=sum(nums);
        int ans=max;
        while(min<=max){
            int mid=min+(max-min)/2;
            if(findSum(nums,mid,k)){
                ans=mid;
                max=mid-1;
            }else{
                min=mid+1;
            }
        }
        return ans;

    }
    public int maximum(int[] nums){
        int max=Integer.MIN_VALUE;
        for(int num: nums){
            max=Math.max(max,num);
        }
        return max;
    }
    public int sum(int[] nums){
        int ans=0;
        for(int num: nums){
            ans+=num;
        }
        return ans;
    }
    public boolean findSum(int[] nums, int mid, int k){
        int count=1;
        int sum=0;
        for(int num:nums){
            if(sum+num>mid){
                count++;
                sum=num;
                if(count>k) return false;
            }else{
                sum+=num;
            }
        }
        return true;
    }
}