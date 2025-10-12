
import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        int[][] cars= new int[n][2];
        for(int i=0;i<n;i++){
            cars[i][0]=position[i];
            cars[i][1]=speed[i];
        }
        Stack<Double> stack= new Stack<>();
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        for(int[] car:cars){
            int pos=car[0];
            int spd=car[1];
            double timeTaken=(double)(target-pos)/spd;
            if(stack.isEmpty() || timeTaken>stack.peek()){
                stack.push(timeTaken);
            }
        }
        return stack.size();
    }
}