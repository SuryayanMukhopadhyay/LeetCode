class Solution {
    public static void findIslands(char[][] grid, int i, int j, boolean[][] visited, int m, int n) {
        if (i < 0 || i == m || j < 0 || j == n || grid[i][j] != '1') {
            return;
        }
        if(visited[i][j]) return;
        visited[i][j] = true;
        findIslands(grid, i + 1, j, visited, m, n);
        findIslands(grid, i - 1, j, visited, m, n);
        findIslands(grid, i, j + 1, visited, m, n);
        findIslands(grid, i, j - 1, visited, m, n);
    }

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    findIslands(grid, i, j, visited, m, n);
                }
            }
        }
        return count;
    }
}