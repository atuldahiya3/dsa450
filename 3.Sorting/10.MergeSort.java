import java.util.ArrayList; 
class Solution3 {

    void mergeSort(int arr[], int l, int r) {
        if(l>=r){
            return;
        }
        int mid= l+(r-l)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    void merge(int arr[], int st, int mid, int end){
        ArrayList<Integer> temp=new ArrayList<>();
        int i=st;
        int j=mid+1;
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp.add(arr[i]);
                i++;
            }else{
                temp.add(arr[j]);
                j++;
            }
        }
        while(i<=mid){
            temp.add(arr[i]);
            i++;
        }
        while(j<=end){
            temp.add(arr[j]);
            j++;
        }
        
        for(int k=0;k<temp.size();k++){
            arr[k+st]=temp.get(k);
        }
    }
}