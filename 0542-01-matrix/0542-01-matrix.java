class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> Q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    Q.offer(new int[] {i, j});
                }
                else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(!Q.isEmpty()) {
            int[] temp = Q.poll();
            int row = temp[0];
            int col = temp[1];
            if(row > 0) {
                if(mat[row][col] + 1 < mat[row - 1][col]) {
                    mat[row - 1][col] = mat[row][col] + 1;
                    Q.offer(new int[] {row - 1, col});
                }
            }
            if(row < m - 1) {
                if(mat[row][col] + 1 < mat[row + 1][col]) {
                    mat[row + 1][col] = mat[row][col] + 1;
                    Q.offer(new int[] {row + 1, col});
                }
            }
            if(col > 0) {
                if(mat[row][col] + 1 < mat[row][col - 1]) {
                    mat[row][col - 1] = mat[row][col] + 1;
                    Q.offer(new int[] {row, col - 1});
                }
            }
            if(col < n - 1) {
                if(mat[row][col] + 1 < mat[row][col + 1]) {
                    mat[row][col + 1] = mat[row][col] + 1;
                    Q.offer(new int[] {row, col + 1});
                }
            }
        }
        return mat;
    }
}