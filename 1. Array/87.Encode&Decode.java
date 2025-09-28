class Solution {

    public String encode(String s[]) {
        // write your logic to encode the strings
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<s.length;i++){
            sb.append(s[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public String[] decode(String s) {
        // write your logic to decode the string
        String[] res= s.split(" ");
        return res;
    }
}