class Solution3 {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=maximum(piles);
        int res=right;
        while(left<=right){
            int speed=left+(right-left)/2;
            if(canEatAll(piles,h,speed)){
                res=speed;
                right=speed-1;
            }else{
                left=speed+1;
            }
        }
        return res;
    }
    public int maximum(int[] piles){
        int res=Integer.MIN_VALUE;
        for(int pile: piles){
            res=Math.max(pile,res);
        }
        return res;
    }
    public boolean canEatAll(int[] piles, int h, int k){
    long hours = 0;
    for(int pile : piles){
        hours += (pile + k - 1) / k; // ceiling division
        if (hours > h) return false; // early exit
    }
    return hours <= h;
}
}