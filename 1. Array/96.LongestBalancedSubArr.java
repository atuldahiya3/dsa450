
import java.util.HashSet;

class Solution {
    public int longestBalanced(int[] nums) {
        int ans=0;
        for(int j=0;j<nums.length;j++){
            HashSet<Integer> oddSet= new HashSet<>();
            HashSet<Integer> evenSet= new HashSet<>();
            for(int i=j;i<nums.length;i++){
                if(nums[i]%2==0){
                    evenSet.add(nums[i]);
                }else{
                    oddSet.add(nums[i]);
                }
                if(evenSet.size()==oddSet.size()) ans=Math.max(ans,i-j+1);
            }
        }
        return ans;
    }
}