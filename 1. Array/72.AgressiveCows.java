import java.util.Arrays;

class Solution72 {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int min=1;
        int max=stalls[stalls.length-1]-stalls[0];
        int res=0;
        
        while(min<=max){
            int mid= min+(max-min)/2;
            if(checkDist(stalls,mid,k)){
                res=mid;
                min=mid+1;
            }else{
                max=mid-1;
            }
        }
        return res;
        
    }
    public static boolean checkDist(int[] stalls, int dist, int k){
        int count=1;
        int lastPlaced=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-lastPlaced>=dist){
                count++;
                lastPlaced=stalls[i];
            }
            if(count==k){
                return true;
            }
        }
        return false;
    }
}