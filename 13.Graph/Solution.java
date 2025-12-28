class Solution {
    public int countBattleships(char[][] board) {
        int r=board.length, c=board[0].length;
        int count=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]=='X'){
                    count++;
                    dfs(i,j,board);
                }
            }
        }
        return count;
    }
    public void dfs(int i, int j, char[][] board){
        int r=board.length, c=board[0].length;
        if(i<0 || j<0 || i>=r || j>=c || board[i][j]=='.') return;
        board[i][j]='.';
        dfs(i,j+1,board);
        dfs(i,j-1,board);
        dfs(i+1,j,board);
        dfs(i-1,j,board);
    }
}