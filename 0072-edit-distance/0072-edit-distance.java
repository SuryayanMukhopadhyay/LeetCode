class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] memo = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++) {
            for(int j = 0; j < n + 1; j++) {
                if(i == 0) {
                    memo[i][j] = j;
                }
                else if(j == 0) {
                    memo[i][j] = i;
                }
            }
        }
        memo[0][0] = 0;
        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1];
                }
                else {
                    memo[i][j] = Math.min(1 + memo[i - 1][j - 1], Math.min(1 + memo[i - 1][j], 1 + memo[i][j - 1]));
                }
            }
        }
        return memo[m][n];
    }
}