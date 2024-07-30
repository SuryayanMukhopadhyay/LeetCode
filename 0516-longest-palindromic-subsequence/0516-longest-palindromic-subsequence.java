class Solution {
    public void reverse(StringBuilder s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char ch = s.charAt(right);
            s.setCharAt(right, s.charAt(left));
            s.setCharAt(left, ch);
            left++;
            right--;
        }
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder rev = new StringBuilder(s);
        reverse(rev);
        int n = s.length();
        int[][] memo = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            memo[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][ j - 1]);
                }
            }
        }
        return memo[n][n];
    }
}