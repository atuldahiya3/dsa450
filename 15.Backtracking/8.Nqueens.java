class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board= new char[n][n];
        List<List<String>> res= new ArrayList<>();
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        helper(board,0,res,n);
        return res;
    }
    public void helper(char[][] board, int row, List<List<String>> res, int n){
        if(row==n){
            List<String> temp= new ArrayList<>();
            for(char[] c: board){
                temp.add(new String(c));
            }
            res.add(temp);
        }

        for(int col=0;col<n;col++){
            if(isSafe(board,row,col,n)){
                board[row][col]='Q';
                helper(board,row+1,res,n);
                board[row][col]='.';
            }
        }
    }
    public boolean isSafe(char[][] board, int row, int col, int n){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}