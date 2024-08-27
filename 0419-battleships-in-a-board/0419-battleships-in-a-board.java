class Solution {
    public void dfs(char[][] board, int i, int j, int m, int n, boolean[][] visited) {
        if(i < 0 || i > m - 1 || j < 0 || j > n - 1) {
            return;
        }
        if(board[i][j] != 'X' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(board, i + 1, j, m, n, visited);
        dfs(board, i - 1, j, m, n, visited);
        dfs(board, i, j + 1, m, n, visited);
        dfs(board, i, j - 1, m, n, visited);
    }
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'X' && !visited[i][j]) {
                    dfs(board, i, j, m, n, visited);
                    count++;
                }   
            }
        }
        return count;
    }
}