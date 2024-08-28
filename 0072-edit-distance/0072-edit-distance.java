class Solution {
    public int helper(String word1, String word2, int m, int n, int[][] memo) {
        if(m == 0) {
            return n;
        }
        if(n == 0) {
            return m;
        }
        if(memo[m][n] != -1) {
            return memo[m][n];
        }
        if(word1.charAt(m - 1) == word2.charAt(n - 1)) {
            return memo[m][n] = helper(word1, word2, m - 1, n - 1, memo);
        }
        int replace = 1 + helper(word1, word2, m - 1, n - 1, memo);
        int delete = 1 + helper(word1, word2, m - 1, n, memo);
        int insert = 1 + helper(word1, word2, m, n - 1, memo);
        return memo[m][n] = Math.min(replace, Math.min(delete, insert));
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] memo = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++) {
            for(int j = 0; j < n + 1; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(word1, word2, m, n, memo);
    }
}