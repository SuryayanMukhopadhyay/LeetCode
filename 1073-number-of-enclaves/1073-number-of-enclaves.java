class Solution {
    public static void dfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(grid, i + 1, j, m, n, visited);
        dfs(grid, i - 1, j, m, n, visited);
        dfs(grid, i, j + 1, m, n, visited);
        dfs(grid, i, j - 1, m, n, visited);
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if((i == 0 || i == m - 1 || j == 0 || j == n - 1) && grid[i][j] == 1) {
                    dfs(grid, i, j, m, n, visited);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                } 
            }
        }
        return count;
    }
}