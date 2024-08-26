class Solution {
    public void dfs(int[][] grid1, int[][] grid2, int i, int j, int[] arr, boolean[][] visited, int m, int n) {
        if(i < 0 || i > m - 1 || j < 0 || j > n - 1) {
            return;
        }
        if(grid2[i][j] != 1 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if(grid1[i][j] == 1) {
            arr[0]++;
        }
        arr[1]++;
        dfs(grid1, grid2, i + 1, j, arr, visited, m, n);
        dfs(grid1, grid2, i - 1, j, arr, visited, m, n);
        dfs(grid1, grid2, i, j + 1, arr, visited, m, n);
        dfs(grid1, grid2, i, j - 1, arr, visited, m, n);
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid2[i][j] == 1 && !visited[i][j]) {
                    int[] arr = new int[2];
                    arr[0] = 0;
                    arr[1] = 0;
                    dfs(grid1, grid2, i, j, arr, visited, m, n);
                    if(arr[0] == arr[1]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}