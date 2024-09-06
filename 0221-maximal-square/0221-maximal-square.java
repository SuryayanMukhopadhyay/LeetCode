class Solution {
    public int dfs(char[][] matrix, int i, int j, int m, int n, int[][] memo) {
        if(i < 0 || i > m - 1 || j < 0 || j > n - 1 || matrix[i][j] == '0') {
            return 0;
        }
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        int one = dfs(matrix, i + 1, j, m, n, memo);
        int two = dfs(matrix, i + 1, j + 1, m, n, memo);
        int three = dfs(matrix, i, j + 1, m, n, memo);
        return memo[i][j] = 1 + Math.min(one, Math.min(two, three));
    }
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int result = Integer.MIN_VALUE;
        int[][] memo = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    result = Math.max(result, dfs(matrix, i, j, m, n, memo));
                }
            }
        }
        return result * result;
    }
}