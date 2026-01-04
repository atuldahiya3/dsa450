class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        int A=0, B=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0' && t.charAt(i)=='1') A++;
            if(s.charAt(i)=='1' && t.charAt(i)=='0') B++;
        }
        long ans=(long) (A+B)*flipCost;
        int C = Math.max(A,B) - Math.min(A,B);
        long costSwap=(long) Math.min(A,B)*swapCost;
        long costFlip=(long) (C/2)*(swapCost+crossCost) + (long) (C%2)*(flipCost);
        costSwap+=Math.min(costFlip , (long)C*flipCost);
        return Math.min(ans,costSwap);
    }
}