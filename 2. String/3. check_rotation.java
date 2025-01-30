class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        int l1=s1.length();
        int l2=s2.length();
        
        if(l1!=l2){
            return false;
        }
        String concatenated = s1 + s1;
        return concatenated.contains(s2);
    }
}