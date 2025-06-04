import java.util.Arrays;

class Solution999 {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        int n=arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i=1,j=0;
        int needed=1;
        int max=1;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                needed++;
                i++;
            }else{
                needed--;
                j++;
            }
            max=Math.max(needed,max);
        }
        return max;
    }
}
