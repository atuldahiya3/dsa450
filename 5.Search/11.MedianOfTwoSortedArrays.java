class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged= merge(nums1, nums2);
        int len=merged.length;
        if(len%2!=0){
            return merged[len/2];
        }else{
            return (merged[len/2]+merged[(len/2)-1])/2.0;
        }
    }
    public int[] merge(int[] num1, int[] num2){
        int n1=num1.length;
        int n2=num2.length;
        int[] res= new int[n1+n2];
        int i=0, j=0, k=0;
        while(i<n1 && j<n2){
            if(num1[i]<num2[j]){
                res[k++]=num1[i++];
            }else{
                res[k++]=num2[j++];
            }
        }
        while(i<n1) res[k++]=num1[i++];
        while(j<n2) res[k++]=num2[j++];

        return res;
    }
}