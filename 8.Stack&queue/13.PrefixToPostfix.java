class Solution13 {
    static String preToPost(String pre_exp) {
        // code here
        Stack<String> data= new Stack<>();
        for(int i=pre_exp.length()-1;i>=0;i--){
            char ch= pre_exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                data.push(Character.toString(ch));
            }else{
                String first=data.pop();
                String second=data.pop();
                String temp=first+second+Character.toString(ch);
                data.push(temp);
            }
        }
        return data.peek();
    }
}