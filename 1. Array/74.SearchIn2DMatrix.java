class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start=0;
        int end=matrix.length-1;
        int midIdx=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(matrix[mid][0]<=target && matrix[mid][matrix[mid].length-1]>=target){
                start=0;
                end=matrix[mid].length-1;
                midIdx=mid;
                break;
            }else if(matrix[mid][0]>target){
                end=mid-1;
            }else if(matrix[mid][matrix[mid].length-1]<target){
                start=mid+1;
            }
        }
        while(start<=end){
            int mid=start+(end-start)/2;
            if(matrix[midIdx][mid]==target){
                return true;
            }else if(matrix[midIdx][mid]>target){
                end=mid-1;
            }else if(matrix[midIdx][mid]<target){
                start=mid+1;
            }
        }
        return false;
    }
}