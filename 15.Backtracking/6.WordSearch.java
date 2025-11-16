class Solution {
    public boolean isWordExist(char[][] mat, String word) {
        // Code here
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==(word.charAt(0))){
                    if (helper(mat, word, 0, i, j, new boolean[mat.length][mat[0].length]))
                        return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] mat, String word, int i, int r, int c, boolean[][] visited){
        if(i==word.length()){
            return true;
        }
        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length) return false;
        if (visited[r][c] || mat[r][c] != word.charAt(i)) return false;
        
        visited[r][c]=true;
        boolean found =
                helper(mat, word, i + 1, r + 1, c, visited) ||
                helper(mat, word, i + 1, r - 1, c, visited) ||
                helper(mat, word, i + 1, r, c + 1, visited) ||
                helper(mat, word, i + 1, r, c - 1, visited);

        visited[r][c] = false; // backtrack

        return found;
    }
}