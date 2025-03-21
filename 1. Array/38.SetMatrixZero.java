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
        // below solution is optimized O(m+n) because traversing on arraylist takes more time as compared to boolean array
        public void setZeroesOptimized(int[][] matrix) {
            int row=matrix.length;
            int col=matrix[0].length;
            boolean[] rowFlag= new boolean[row];
            boolean[] colFlag= new boolean[col];
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(matrix[i][j]==0){
                        rowFlag[i]=true;
                        colFlag[j]=true;
                    }
                }
            }
            for(int i=0;i<row;i++){
                if(rowFlag[i]){
                    for(int j=0;j<col;j++){
                        matrix[i][j]=0;
                    }
                }
            }
            for(int i=0;i<col;i++){
                if(colFlag[i]){
                    for(int j=0;j<row;j++){
                        matrix[j][i]=0;
                    }
                }
            }
        }
    
}