class Solution76 {
    public int[] findPeakGrid(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        

        int left=0;
        int right=col-1;

        while(left<=right){
            int midCol=left+(right-left)/2;
            int maxRow=0;
            for(int i=0;i<row;i++){
                if(matrix[i][midCol]>matrix[maxRow][midCol]){
                    maxRow=i;
                }
            }
            int leftElem=midCol-1>=0 ? matrix[maxRow][midCol-1] : -1;
            int rightElem=midCol+1<=col-1 ? matrix[maxRow][midCol+1] : -1;
            int currElem=matrix[maxRow][midCol];

            if(currElem>leftElem && currElem>rightElem){
                return new int[]{maxRow,midCol};
            }else if(currElem<leftElem){
                right=midCol-1;
            }else{
                left=midCol+1;
            }
        }
        return new int[]{-1,-1};
    }
}