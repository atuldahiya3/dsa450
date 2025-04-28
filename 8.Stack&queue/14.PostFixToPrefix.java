// User function Template for Java

class Solution14 {
    static String postToPre(String post_exp) {
        // code here
        Stack<String> data= new Stack<>();
        for(int i=0;i<post_exp.length();i++){
            char ch= post_exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                data.push(Character.toString(ch));
            }else{
                String one=data.pop();
                String two=data.pop();
                String temp=Character.toString(ch)+two+one;
                data.push(temp);
            }
        }
        return data.peek();
    }
}