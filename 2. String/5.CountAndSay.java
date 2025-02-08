class Solution {
    public String countAndSay(int n) {
        String res="1";
        if(n==1){
            return res;
        }
        for(int i=1;i<n;i++){
            res=rle(res);
        }
        return res;
    }
    public String rle(String s){
        int length=s.length();
        char curr=s.charAt(0);
        int count=1;
        StringBuilder res = new StringBuilder();
        if(length==1){
            res.append(count).append(curr);
            return res.toString();
        }
        for(int i=1;i<length;i++){
            if(s.charAt(i)==curr){
                count+=1;
            }else{
                res.append(count).append(curr);
                curr=s.charAt(i);
                count=1;
            }
        }
        res.append(count).append(curr);
        return res.toString();
    }
}