class Solution {
    public boolean helper(char[][] board, String word, int idx, int i, int j, int m, int n, boolean[][] visited) {
        if(idx == word.length()) {
            return true;
        }
        if(i < 0 || i > m - 1 || j < 0 || j > n - 1 || board[i][j] != word.charAt(idx) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if(helper(board, word, idx + 1, i + 1, j, m, n, visited) ||
                helper(board, word, idx + 1, i - 1, j, m, n, visited) ||
                helper(board, word, idx + 1, i, j + 1, m, n, visited) ||
                helper(board, word, idx + 1, i, j - 1, m, n, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char ch = word.charAt(0);
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == ch && !visited[i][j]) {
                    boolean found = helper(board, word, 0, i, j, m, n, visited);
                    if(found) return true;
                }
            }
        }
        return false;
    }
}