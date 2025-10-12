class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int min=1;
        int max=findMax(arr);
        int s=max;
        while(min<max){
            int mid=(min+max)/2;
            if(canEat(arr,k,mid)){
                s=Math.min(s,mid);
                max=mid;
            }else{
                min=mid+1;
            }
        }
        return s;
    }
    public int findMax(int[] arr){
        int n=arr.length;
        int res=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            res=Math.max(res,arr[i]);
        }
        return res;
    }
    public boolean canEat(int[] arr, int k, int s){
        int n=arr.length;
        int count=0;
        for(int i=0;i<n;i++){
            count+=(arr[i]+s-1)/s;
            if(count>k) return false;
        }
        return true;
    }
}
