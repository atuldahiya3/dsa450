class Solution10 {
    public String removeOuterParentheses(String s) {
        StringBuilder res= new StringBuilder();
        int opened=0;
        for(char c : s.toCharArray()){
            if(c=='(' && opened++ > 0) res.append(c);
            if(c==')' && opened-- > 1) res.append(c);
        }
        return res.toString();
    }
}