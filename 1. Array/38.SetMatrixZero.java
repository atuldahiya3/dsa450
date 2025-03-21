import java.util.ArrayList;

class Solution38 {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        ArrayList<Integer> x= new ArrayList<>();
        ArrayList<Integer> y= new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    x.add(i);
                    y.add(j);
                }
            }
        }
        for(int i=0;i<x.size();i++){
            for(int j=0;j<col;j++){
                matrix[x.get(i)][j]=0;
            }
        }
        for(int i=0;i<y.size();i++){
            for(int j=0;j<row;j++){
                matrix[j][y.get(i)]=0;
            }
        }
    }
}