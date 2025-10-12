class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] a= new int[26];
        int[] b= new int[26];
        int l1=s1.length();
        int l2=s2.length();
        if(l1>l2) return false;
        for(int i=0;i<l1;i++){
            a[s1.charAt(i)-'a']++;
            b[s2.charAt(i)-'a']++;
        }
        if(matches(a,b)) return true;
        for(int i=l1;i<l2;i++){
            b[s2.charAt(i)-'a']++;
            b[s2.charAt(i-l1)-'a']--;
            if(matches(a,b)) return true;
        }
        return false;
    }
    public boolean matches(int[] a, int[] b){
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
}