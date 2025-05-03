import java.util.Stack;

class Solution20 {
    public long subArrayRanges(int[] nums) {
        int n=nums.length, j, k;
        long res=0;
        Stack<Integer> s= new Stack<>();

        for(int i=0;i<=n;i++){
            while(!s.isEmpty() && nums[s.peek()] > (i==n ? Integer.MIN_VALUE : nums[i])){
                j=s.pop();
                k=s.isEmpty() ? -1 :s.peek();
                res-= (long)nums[j] * (i-j) * (j-k);
            }
            s.push(i);
        }
        s.clear();
        for(int i=0;i<=n;i++){
            while(!s.isEmpty() && nums[s.peek()]<(i==n ? Integer.MAX_VALUE : nums[i])){
                j=s.pop();
                k=s.isEmpty()? -1 :s.peek();
                res+= (long) nums[j]*(i-j)*(j-k);
            }
            s.push(i);
        }
        return res;
    }
}