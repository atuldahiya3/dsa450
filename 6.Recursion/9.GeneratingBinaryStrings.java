// User function Template for Java

class Solution {
    public static List<String> generateBinaryStrings(int n) {
        // code here
        List<String> res= new ArrayList<>();
        helper(n,"",res);
        return res;
        
    }
    public static void helper(int n, String current, List<String> result){
         if (current.length() == n) {
            result.add(current);
            return;
        }
        
        helper(n,current+"0",result);
        
        if (current.isEmpty() || current.charAt(current.length() - 1) != '1') {
            helper(n,current+"1",result);
        }
    }
}
