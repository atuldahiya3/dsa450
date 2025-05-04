import java.util.Stack;

class Solution23 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxRectangle=0;
        int rows= matrix.length;
        int cols= matrix[0].length;
        int[] heights=new int[cols];
        for(int i=0;i<rows;i++){
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;  // increase height
                } else {
                    heights[j] = 0;   // reset on '0'
                }
            }
            maxRectangle=Math.max(maxRectangle, findMaxRectangle(heights));
        }
        return maxRectangle;
    }
    public int findMaxRectangle(int[] nums){
        int n= nums.length;
        Stack<Integer> stack= new Stack<>();
        int maxArea=0;
        for(int i=0;i<=n;i++){
            int h= (i==n) ? 0 : nums[i];
            while(!stack.isEmpty() && h< nums[stack.peek()]){
                int height=nums[stack.pop()];
                int width= stack.isEmpty() ? i : i-stack.peek()-1;
                maxArea= Math.max(maxArea, height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}