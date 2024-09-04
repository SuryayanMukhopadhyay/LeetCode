class Solution {
    public int helper(int[][] matrix, int i, int j, int m, int n, int prev, boolean[][] visited, int[][] memo) {
        if(i < 0 || i > m - 1 || j < 0 || j > n - 1 || visited[i][j]) {
            return 0;
        }
        if(matrix[i][j] <= prev) {
            return 0;
        }
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        visited[i][j] = true;
        int up = helper(matrix, i - 1, j, m, n, matrix[i][j], visited, memo);
        int down = helper(matrix, i + 1, j, m, n, matrix[i][j], visited, memo);
        int right = helper(matrix, i, j + 1, m, n, matrix[i][j], visited, memo);
        int left = helper(matrix, i, j - 1, m, n, matrix[i][j], visited, memo);
        visited[i][j] = false;
        return memo[i][j] = 1 + Math.max(Math.max(Math.max(up, down), left), right);
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int max = Integer.MIN_VALUE;
        int[][] memo = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(max, helper(matrix, i, j, m, n, -1, visited, memo));
            }
        }
        return max;
    }
}