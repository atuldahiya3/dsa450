class Solution70 {
    public int shipWithinDays(int[] weights, int days) {
        int min=minimum(weights);
        int max=maximum(weights);
        int res=max;
        while(min<=max){
            int mid= min+(max-min)/2;
            if(checkDays(weights, mid, days)){
                res=mid;
                max=mid-1;
            }else{
                min=mid+1;
            }
        }
        return res;
    }
    public int maximum(int[] weights){
        int ans=0;
        for(int weight: weights){
            ans+=weight;
        }
        return ans;
    }
    public int minimum(int[] weights){
    int maxWeight = 0;
    for (int weight : weights) {
        maxWeight = Math.max(maxWeight, weight);
    }
    return maxWeight;
}
    public boolean checkDays(int[] weights, int mid, int days){
        int daysCounted=1;
        int sum=0;
        for(int weight:weights){
            if(sum+weight>mid){
                daysCounted++;
                sum=0;
            }
            sum+=weight;
        }
        return daysCounted<=days;
    }
}