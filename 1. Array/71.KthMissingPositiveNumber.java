class Solution71 {
    public int findKthPositive(int[] arr, int k) {
        int min=1;
        int max=maximum(arr)+k;
        int res=-1;
        while(min<=max){
            int mid=min+(max-min)/2;
            int missing=countMissing(arr,mid);
            if(missing<k){
                min=mid+1;
            }else{
                res=mid;
                max=mid-1;
            }
        }
        return res;
    }
    public int maximum(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int ele: arr){
            max=Math.max(ele,max);
        }
        return max;
    }
    public int countMissing(int[] arr, int mid){
        int count=0;
        for(int num: arr){
            if(num<=mid){
                count++;
            }else{
                break;
            }
        }
        return mid-count;
    }
}