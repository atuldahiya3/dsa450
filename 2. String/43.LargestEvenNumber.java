class Solution {
    public String largestEven(String s) {
        int l = s.lastIndexOf('2');
        if(l<=-1) return "";
        return s.substring(0,l+1);
    }
}