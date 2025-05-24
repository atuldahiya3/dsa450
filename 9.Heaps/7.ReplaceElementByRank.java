import java.util.HashMap;
import java.util.TreeSet;

class Solution7 {
    static int[] replaceWithRank(int arr[], int N) {
        // code here
        HashMap<Integer,Integer> map= new HashMap<>();
        TreeSet<Integer> sortedSet = new TreeSet<>();
        for(int num:arr){
            sortedSet.add(num);
        }
        int count=1;
        for(int num:sortedSet){
            map.put(num,count);
            count++;
        }
        for(int i=0;i<arr.length;i++){
            arr[i]= map.get(arr[i]);
        }
        return arr;
    }
}
