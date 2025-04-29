import java.util.Stack;

class Solution17 {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int arr[]= new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            arr[i]=-1;
        }
        for(int i=0;i<n*2;i++){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i%n]){
                arr[stack.pop()]=nums[i%n];
            }
            if(i<n){
                stack.push(i);
            }
        }
        return arr;
    }
}