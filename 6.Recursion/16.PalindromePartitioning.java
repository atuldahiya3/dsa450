class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res= new ArrayList<>();
        findPairs(s, 0, new ArrayList<>(), res);
        return res;
    }
    public static void findPairs(String s, int start, List<String> pairs, List<List<String>> res){
        if(start==s.length()){
            res.add(new ArrayList<>(pairs));
            return;
        }
        for(int end=start+1;end<=s.length();end++){
            String subStr=s.substring(start,end);
            if(isPalindrome(subStr)){
                pairs.add(subStr);
                findPairs(s, end, pairs, res);
                pairs.remove(pairs.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s){
        int l=0, r=s.length()-1;
        while(l<r){
            if(s.charAt(l++)!=s.charAt(r--)) return false;
        }
        return true;
    }
}