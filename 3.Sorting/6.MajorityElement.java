import java.util.Arrays;

class SolutionMajority {
    static int majorityElement(int arr[]) {
        Arrays.sort(arr);
        int l=arr.length;
        int count=1;
        int prev=arr[0];
        if(l==1){
            return arr[0];
        }
        for(int i=1;i<l;i++){
            if(arr[i]==prev){
                count++;
                if(count>l/2){
                    return prev;
                }
            }else{
                prev=arr[i];
                count=1;
            }
        }
        return -1;
    }
}