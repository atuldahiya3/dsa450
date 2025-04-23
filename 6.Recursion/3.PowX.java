class Solution3 {
    public double myPow(double x, int n) {
        long N=n;
        if(n<0){
            x=1/x;
            n=-n;
        }
        return power(x,n);
    }
    public double power(double x, long n){
        if(n==0) return 1.0;
        double half=power(x,n/2);
        if(n%2==0){
            return half*half;
        }else{
            return half*half*x;
        }
    }
}