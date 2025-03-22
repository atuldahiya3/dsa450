import java.util.ArrayList;
import java.util.List;

class Solution40 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int top=0;
        int bottom=row-1;
        int left=0;
        int right=col-1;
        ArrayList<Integer> res= new ArrayList<>();
        while(top<=bottom && left<=right){
            //copy from top (horizontal)
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            top++;
            //copy from right (vertical)
            for(int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                //copy from bottom (horizontal)
                for(int i=right;i>=left;i--){
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                //copy from left (vertical)
                for(int i=bottom;i>=top;i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}