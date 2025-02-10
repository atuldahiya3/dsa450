import java.util.ArrayList;
import java.util.Arrays;

class Solution2 {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Arrays.sort(arr);
        int length=arr.length;
        int i=0,j=length-1;
        
        while(i<j){
            if(arr[i]+arr[j]==0){
                ArrayList<Integer> temp=new ArrayList<>(2);
                temp.add(arr[i]);
                temp.add(arr[j]);
                res.add(temp);
                int leftVal=arr[i];
                while(i<j && arr[i]==leftVal){
                    i++;
                }
                int rightVal=arr[j];
                while(i<j && arr[j]==rightVal){
                    j--;
                }
            }else if(arr[i]+arr[j]<0){
                i++;
            }else{
                j--;
            }
            
        }
        return res;
    }
}
