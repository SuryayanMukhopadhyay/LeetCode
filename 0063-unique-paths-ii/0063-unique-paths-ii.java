class Solution {
    public int dfs(int[][] grid, int m, int n, boolean[][] visited, int[][] memo) {
        if(m == 0 && n == 0) {
            if(grid[m][n] == 1) {
                return 0;
            }
            return 1;
        }
        if(m < 0 || n < 0 || visited[m][n] || grid[m][n] == 1) {
            return 0;
        }
        if(memo[m][n] != -1) {
            return memo[m][n];
        }
        visited[m][n] = true;
        int left = dfs(grid, m, n - 1, visited, memo);
        int up = dfs(grid, m - 1, n, visited, memo);
        visited[m][n] = false;
        return memo[m][n] = left + up;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] memo = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return dfs(obstacleGrid, m - 1, n - 1, visited, memo);
    }
}