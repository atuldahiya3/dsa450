class Solution {
    public String convert(String s, int numRows) {
        if(numRows<=2){
            return s;
        }
        int n= s.length();
        int left=0;
        int i=0;
        StringBuilder res= new StringBuilder();
        while(left<n){
            if(i+numRows>=n && left++<n){
                left++;
                i=left;
                res.append(s.charAt(i));
            }
            if(i%2==0){
                res.append(s.charAt(i+(numRows-2)));
            }else{
                res.append(s.charAt(i-(numRows-2)));
            }
            i++;
        }
        return res.toString();
    }
}