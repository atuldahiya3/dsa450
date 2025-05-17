class Solution4 {
    static final int MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long evenCount=(n+1)/2;
        long oddCount=n/2;

        long evenWays=power(5, evenCount);
        long oddWays=power(4, oddCount);

        return (int)((evenWays*oddWays)%MOD);
    }
    public long power(long base, long exp){
        if(exp==0) return 1;
        if(exp==1) return base % MOD;

        long half=power(base, exp/2);
        long result=(half*half)%MOD;

        if(exp%2==1){
            result=(result*base)%MOD;
        }
        return result;
    }
}