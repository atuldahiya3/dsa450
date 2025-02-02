import java.util.ArrayList;

class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> res=new ArrayList<>();
        int n=txt.length();
        int m=pat.length();
        if (m > n) return res;
        int[] lps = new int[m];
        int len=0;
        int i=1;
        
        while(i<pat.length()){
            if(pat.charAt(i)==pat.charAt(len)){
                len+=1;
                lps[i]=len;
                i+=1;
            }else{
                if(len!=0){
                    len=lps[len-1];
                }else{
                    lps[i]=0;
                    i+=1;
                }
            }
        }
        
        i=0;
        int j=0;
        
        while(i<txt.length()){
            if(pat.charAt(j)==txt.charAt(i)){
                i+=1;
                j+=1;
            }
            if(j==pat.length()){
                res.add(i-j);
                j=lps[j-1];
            }else if (i < n && txt.charAt(i) != pat.charAt(j)){
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return res;
    }
}