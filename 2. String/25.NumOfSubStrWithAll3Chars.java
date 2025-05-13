class Solution {
    public int numberOfSubstrings(String s) {
        int[] abc= new int[3];
        for(int i=0;i<abc.length;i++){
            abc[i]=-1;
        }
        char[] data= s.toCharArray();
        int right=0, count=0;
        while (right<data.length){
            abc[data[right]-'a']=right;
            int minIndex=Integer.MAX_VALUE;
            for(int i=0;i<3;i++){
                minIndex=Math.min(minIndex, abc[i]);
            }
            count+=minIndex+1;
            right++;
        }
        return count;
    }
}