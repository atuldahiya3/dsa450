
import java.util.Arrays;

class Solution {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        int c=0;
        if(k==0) return nums.length;
        int num=nums[nums.length-k];
        for(int i=nums.length-k-1;i>=0;i--){
            if(nums[i]<num) c++;
        }
        return c;
    }
}