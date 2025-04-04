class Solution48 {
    public int reversePairs(int[] nums) {
        int temp[]= new int[nums.length];
        return mergeSort(nums, temp, 0, nums.length-1);
    }
    public int mergeSort(int arr[],int temp[], int start, int end){
        int count=0;
        if(start<end){
            int mid=start+(end-start)/2;
            count+=mergeSort(arr, temp, start, mid);
            count+=mergeSort(arr,temp,mid+1,end);
            count+=countPairs(arr,start,mid,end);
            merge(arr,temp,start,mid,end);
        }
        return count;
    }
    public int countPairs(int arr[], int start, int mid, int end){
        int i=start, j=mid+1,count=0;
        
        for(i=start;i<=mid;i++){
            while(j<=end && arr[i]>2L*arr[j]){
                j++;
            }
            count+=(j-(mid+1));
        }
        return count;
    }
    public void merge(int arr[], int temp[], int start, int mid, int end){
        int i=start,j=mid+1,k=0;
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=end){
            temp[k++]=arr[j++];
        }
        for(i=start;i<=end;i++){
            arr[i]=temp[i-start];
        }
    }
}