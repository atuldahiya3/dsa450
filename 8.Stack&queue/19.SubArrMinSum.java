import java.util.Stack;

class Solution19 {
    public int sumSubarrayMins(int[] arr) {
        int MOD=1_000_000_007;
        int n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> stack= new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            left[i]=stack.isEmpty() ? i+1 : i-stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            right[i]=stack.isEmpty() ? n-i : stack.peek()-i;
            stack.push(i);
        }
        long result=0;
        for(int i=0;i<n;i++){
            long sumUp= (long) left[i]*right[i];
            long contribution=sumUp*arr[i];
            result=(result+contribution)%MOD;
        }
        return (int)result;
    }
}