import java.util.ArrayList;
import java.util.Arrays;

    public int[] getSubarrayBeautyBruteForce(int[] nums, int k, int x) {
        ArrayList<Integer> res=new ArrayList<>();
        int l=nums.length;
        int temp=0;
        for(int i=0;i<=l-k;i++){
            temp=selectedSmallestNegative(Arrays.copyOfRange(nums,i,i+k),x);
            res.add(temp);
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    public int selectedSmallestNegative(int[] arr, int x){
        Arrays.sort(arr);
        if(arr.length<x){
            return 0;
        }
        if(arr[x-1]<0){
            return arr[x-1];
        }else{
            return 0;
        }
    }

    //optimized
    
        public int[] getSubarrayBeauty(int[] nums, int k, int x) {
            int l=nums.length;
            //-> initialize array counter to store count record of negative elements from -50 to -1
            int[] counter=new int[50]; 
            //-> ans array to store xth smallest element of each subarray
            int[] ans=new int[l-k+1];
    
            for(int i=0;i<l;i++){
                //-> if the element is negative, increment its count in the counter array in positive terms by adding 50
                if(nums[i]<0){
                    counter[nums[i]+50]++;
                }
                //-> if the element is negative but outside the subarray limit, decrement its count in the counter array in positive terms by adding 50
                if(i-k>=0 && nums[i-k]<0){
                    counter[nums[i-k]+50]--;
                }
                //-> keep sliding untill subarray of size k is reached
                if(i-k+1<0) continue;
                int count=0;
                //-> iterate over the counter array to find the xth smallest element
                for(int j=0;j<50;j++){
                    //-> increment count with the elements conatining elements in counter array, only orignal negative value elements are there in counter array
                    count+=counter[j];
                    //-> if xth smallest element is found, store it in ans array and break the loop
                    if(count>=x){
                        ans[i-k+1]=j-50;
                        break;
                    }
                }
            }
            return ans;
        }
    
}