class Solution {
    public void dfs(int[][] grid, int i, int j, int m, int n, int[] arr, boolean[][] visited) {
        if(i < 0 || i > m - 1 || j < 0 || j > n - 1 || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        arr[0] = arr[0] + grid[i][j];
        dfs(grid, i + 1, j, m, n, arr, visited);
        dfs(grid, i - 1, j, m, n, arr, visited);
        dfs(grid, i, j + 1, m, n, arr, visited);
        dfs(grid, i, j - 1, m, n, arr, visited);
    }
    public int findMaxFish(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) {
                    int[] arr = new int[1];
                    arr[0] = 0;
                    dfs(grid, i, j, m, n, arr, visited);
                    max = Math.max(max, arr[0]);
                }
            }
        }
        return max;
    }
}