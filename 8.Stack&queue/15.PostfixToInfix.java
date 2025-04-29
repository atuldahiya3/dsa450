class Solution15 {
    static String postToInfix(String exp) {
        // code here
        Stack<String> data= new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                data.push(Character.toString(ch));
            }else{
                String one=data.pop();
                String two=data.pop();
                String temp='('+two+Character.toString(ch)+one+')';
                data.push(temp);
            }
        }
        return data.peek();
    }
}