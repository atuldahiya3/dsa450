import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows= new HashSet[9];
        HashSet<Character>[] cols= new HashSet[9];
        HashSet<Character>[] box= new HashSet[9];
        for(int i=0;i<9;i++){
            rows[i]=new HashSet<>();
            cols[i]=new HashSet<>();
            box[i]=new HashSet<>();
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                char val=board[i][j];
                int boxValue=  (i / 3) * 3 + (j / 3);
                if(rows[i].contains(board[i][j]) || cols[j].contains(board[i][j]) || box[boxValue].contains(val)) return false;
                rows[i].add(val);
                cols[j].add(val);
                box[boxValue].add(val);
            }
        }
        return true;
    }
}