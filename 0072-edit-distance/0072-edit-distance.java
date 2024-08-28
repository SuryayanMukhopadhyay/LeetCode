class Solution {
    public int helper(String word1, String word2, int m, int n) {
        if(m == 0) {
            return n;
        }
        if(n == 0) {
            return m;
        }
        if(word1.charAt(m - 1) == word2.charAt(n - 1)) {
            return helper(word1, word2, m - 1, n - 1);
        }
        int replace = 1 + helper(word1, word2, m - 1, n - 1);
        int delete = 1 + helper(word1, word2, m - 1, n);
        int insert = 1 + helper(word1, word2, m, n - 1);
        return Math.min(replace, Math.min(delete, insert));
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        return helper(word1, word2, m, n);
    }
}