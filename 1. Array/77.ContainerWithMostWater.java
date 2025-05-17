class Solution77 {
    public int maxArea(int[] height) {
        int max=0;
        int left=0, right=height.length-1;
        while(left<right){
            int h= Math.min(height[left],height[right]);
            int w= right-left;
            max=Math.max(max, h*w);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}