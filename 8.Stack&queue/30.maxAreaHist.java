
import java.util.Stack;

class Solution {
    public static int getMaxArea(int arr[]) {
        // code here
        Stack<Integer> s= new Stack<>();
        int maxArea=0;
        int n = arr.length;
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>arr[i]){
                int h=arr[s.pop()];
                int w=s.isEmpty() ? i : i-s.peek()-1;
                maxArea=Math.max(maxArea,h*w);
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int h=arr[s.pop()];
            int w=s.isEmpty() ? n : n-s.peek()-1;
            maxArea=Math.max(maxArea,h*w);
        }
        return maxArea;
    }
}
