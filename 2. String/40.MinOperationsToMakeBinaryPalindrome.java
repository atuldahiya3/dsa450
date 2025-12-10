class Solution {
    public int[] minOperations(int[] nums) {
        int[] res= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i]=stepsToBinary(nums[i]);
        }
        return res;
    }
    private int stepsToBinary(int n){
        int up=n, down=n;
        int stepsUp=0, stepsDown=0;
        while(!isPalindrome(Integer.toBinaryString(up))){
            up++;
            stepsUp++;
        }
        while(!isPalindrome(Integer.toBinaryString(down))){
            down--;
            stepsDown++;
        }
        if(stepsDown<0) return stepsUp;
        return Math.min(stepsUp, stepsDown);
    }
    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}