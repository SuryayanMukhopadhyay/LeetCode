class Solution {
    public static void helper(char[][] board, int i, int j, int m, int n) {
        if(i < 0 || i == m || j < 0 || j == n || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        helper(board, i-1, j, m, n);
        helper(board, i+1, j, m, n);
        helper(board, i, j-1, m, n);
        helper(board, i, j+1, m, n);
    }
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O' && (i == 0 || i == m - 1) || j == 0 || j == n - 1) {
                    helper(board, i, j, m, n);
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}