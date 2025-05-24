class Solution65 {
    public int reverse(int x) {
        if(x>Integer.MAX_VALUE || x< Integer.MIN_VALUE) return 0;
        int ans=0;
        boolean neg=false;
        if(x<0){
            neg=true;
            x=(-x);
        }
        while(x>0){
            int digit=x%10;
            x/=10;
           if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // Positive overflow
            }

            ans = ans * 10 + digit;;
        }
        if(neg) return -ans;
        return ans;
    }
}