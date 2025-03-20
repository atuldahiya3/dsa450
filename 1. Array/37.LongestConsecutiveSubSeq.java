import java.util.HashSet;

class Solution37 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set= new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int maxLen=0;
        //iterating directly over the set instead of nums to avoid duplicate element lookups
        for(int num:set){
            //check if the element is beginning of sequence, no element smaller if present
            if(!set.contains(num-1)){ 
                int currNum=num;
                int currCount=1;
                // run a loop to find count of the sequence
                while(set.contains(currNum+1)){
                    currNum++;
                    currCount++;
                }
                //update max length
                maxLen=Math.max(maxLen, currCount);
            }
        }
        return maxLen;
    }
}