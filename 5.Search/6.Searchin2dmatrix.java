class Solution {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int r=mat.length, c= mat[0].length;
        int i=0, j=c-1;
        while(i<r && j>=0){
            if(mat[i][j]==x) return true;
            if(mat[i][j]<x){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
