import java.util.LinkedList;
import java.util.Queue;

class Solution8 {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int[][] res = new int[row][col];
        Queue<int[]> q = new LinkedList<>();

        // Initialize with large values for 1s and queue all 0s
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    res[i][j] = -1; // mark unprocessed
                }
            }
        }

        int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < row && ny < col && res[nx][ny] == -1) {
                    res[nx][ny] = res[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return res;
    }
}
