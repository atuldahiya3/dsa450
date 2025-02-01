import java.util.ArrayList;

class GFG {
    ArrayList<Integer> find(int arr[], int x) {
        ArrayList<Integer> result=new ArrayList<>();
        int first=-1;
        int last=-1;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                if(first==-1){
                    first=i;
                }
                last=i;
            }
        }
            result.add(first);
            result.add(last);

        return result;
    }
}