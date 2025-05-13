class Solution68 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged= merge(nums1, nums2);
        int n=merged.length;
        if(n%2==0){
            return (merged[n/2-1]+merged[n/2])/2.0;
        }else{
            return (merged[n/2]);
        }
    }
    public int[] merge(int[] nums1, int[] nums2){
        int n=nums1.length, m=nums2.length;
        int i=0,j=0,k=0;
        int merged[]=new int[m+n];
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                merged[k++]=nums1[i++];
            }else{
                merged[k++]=nums2[j++];
            }
        }
        while(i<n) merged[k++]=nums1[i++];
        while(j<m) merged[k++]=nums2[j++];

        return merged;
    }
}