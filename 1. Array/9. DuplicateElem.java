class Solution {
    public int findDuplicate(int[] nums) {
        int repetitive=0;
        Set<Integer> temp=new HashSet<>();
        for(int i=0; i<nums.length; i++){
            int l=temp.size();
            temp.add(nums[i]);
            int newLen=temp.size();
            if(l != newLen-1){
                repetitive=nums[i];
                break;
            }
        }
        return repetitive;
    }
}