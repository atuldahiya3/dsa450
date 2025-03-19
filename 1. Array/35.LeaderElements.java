import java.util.ArrayList;

class Solution35 {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        res.add(arr[arr.length-1]);
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>=res.get(res.size()-1)){
                res.add(arr[i]);
            }
        }
        int l=res.size();
        for(int i=0; i<l/2;i++){
            int temp = res.get(i);
            res.set(i, res.get(l - i - 1));
            res.set(l - i - 1, temp);
        }
        return res;
    }
    
}