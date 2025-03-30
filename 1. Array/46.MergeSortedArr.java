class Solution46 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first= m-1;
        int second= n-1;
        int new1= m+n-1;
        while(second>=0){
            if(first>=0 && nums1[first]>nums2[second]){
                nums1[new1--]=nums1[first--];
            }else{
                nums1[new1--]=nums2[second--];
            }
        }
        
    }
}