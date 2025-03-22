class Solution39 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(i==j){
                    break;
                }
                matrix[i][j]=matrix[i][j]+matrix[j][i]-(matrix[j][i]=matrix[i][j]);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                matrix[i][j]=matrix[i][n-j-1]+matrix[i][j]-(matrix[i][n-j-1]=matrix[i][j]);
            }
        }
    }
}