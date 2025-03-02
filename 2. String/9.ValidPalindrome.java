class Solution2 {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        if(s.length()==0 || s.length()==1){
            return true;
        }
        while(i<j){
            char firstChar=s.charAt(i);
            char lastChar=s.charAt(j);
            if(!Character.isLetterOrDigit(firstChar)){
                i++;
            }
            else if(!Character.isLetterOrDigit(lastChar)){
                j--;
            }
            else{
                if(Character.toLowerCase(firstChar)!=Character.toLowerCase(lastChar)){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}