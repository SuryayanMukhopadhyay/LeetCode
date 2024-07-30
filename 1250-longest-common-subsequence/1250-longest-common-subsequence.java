class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            memo[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            memo[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                }
                else {
                    memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
                }
            }
        }
        return memo[m][n];
    }
}