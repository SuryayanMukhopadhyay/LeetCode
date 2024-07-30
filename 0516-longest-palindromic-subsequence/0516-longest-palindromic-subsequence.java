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

    public int lcs(String s, StringBuilder rev, int m, int n, int[][] memo) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        } else {
            if (s.charAt(m - 1) == rev.charAt(n - 1)) {
                return memo[m][n] = 1 + lcs(s, rev, m - 1, n - 1, memo);
            } else {
                return memo[m][n] = Math.max(lcs(s, rev, m, n - 1, memo), lcs(s, rev, m - 1, n, memo));
            }
        }
    }

    public int longestPalindromeSubseq(String s) {
        StringBuilder rev = new StringBuilder(s);
        reverse(rev);
        int n = s.length();
        int[][] memo = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }
        return lcs(s, rev, n, n, memo);
    }
}