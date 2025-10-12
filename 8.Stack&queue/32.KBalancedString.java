class Solution {
    public String removeSubstring(String s, int k) {
        Stack<Character> stack= new Stack<>();
        for(int j=0;j<s.length();j++){
            stack.push(s.charAt(j));
            if(stack.size()>=2*k){
                boolean isBalanced=true;
                for(int i=0;i<k;i++){
                    if(stack.get(stack.size()-2*k+i)!='('){
                        isBalanced=false;
                    }
                }
                for(int i=k;i < 2 * k && isBalanced; i++){
                    if(stack.get(stack.size()-2*k+i)!=')'){
                        isBalanced=false;
                        break;
                    }
                }
                if(isBalanced){
                    for(int i=0;i<2*k;i++){
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb= new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}