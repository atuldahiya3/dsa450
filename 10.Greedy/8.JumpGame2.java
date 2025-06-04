class Solution89 {
    public int jump(int[] nums) {
        int maxReach=0;
        int jumps=0;
        int currEnd=0;
        for(int i=0;i<nums.length-1;i++){
            maxReach=Math.max(maxReach,i+nums[i]);
            if( i==currEnd ){
                jumps++;
                currEnd=maxReach;
            }
        }
        return jumps;
    }
}