class Solution {
    public int minimumFlips(int n) {
        String binary= Integer.toBinaryString(n);
        StringBuilder reverseSb= new StringBuilder(binary);
        reverseSb.reverse();
        String reverse= new String(reverseSb);
        int count=0;
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)!=reverse.charAt(i)) count++;
        }
        return count;
    }
}©leetcode