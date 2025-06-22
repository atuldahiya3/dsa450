class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result= new ArrayList<>();
        char[][] board= new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        backtrack(board, 0, result, n);
        return result;
    }
    public void backtrack(char[][] board, int row, List<List<String>> result, int n){
        if(row==n){
            List<String> temp= new ArrayList<>();
            for(char[] r : board){
                temp.add(new String(r));
            }
            result.add(temp);
        }
        for(int col=0;col<n;col++){
            if(isSafe(board, row, col, n)){
                board[row][col]='Q';
                backtrack(board, row+1, result, n);
                board[row][col]='.';
            }
        }
    }
    private boolean isSafe(char[][] board, int row, int col, int n) {
        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check top-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check top-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}