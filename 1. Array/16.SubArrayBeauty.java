class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
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
}