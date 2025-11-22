class Solution {
    public int totalWaviness(int num1, int num2) {
        int res=0;
        for(int i=num1;i<=num2;i++){
            res+=peakOrValley(i);
        }
        return res;
    }
    public int peakOrValley(int num){
        int peek=0;
        int valley=0;
        String s= String.valueOf(num);
        for(int i=1;i<s.length()-1;i++){
            if((s.charAt(i)-'0'>s.charAt(i-1)-'0') && (s.charAt(i)-'0'>s.charAt(i+1)-'0')){
                peek++;
            }
            if((s.charAt(i)-'0'<s.charAt(i-1)-'0') && (s.charAt(i)-'0'<s.charAt(i+1)-'0')){
                valley++;
            }
        }
        return peek+valley;
    }
}