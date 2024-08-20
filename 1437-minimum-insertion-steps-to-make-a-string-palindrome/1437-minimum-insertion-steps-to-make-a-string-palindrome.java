class Solution {
    public void reverse(StringBuilder rev) {
        int left = 0, right = rev.length() - 1;
        while(left < right) {
            char ch = rev.charAt(left);
            rev.setCharAt(left, rev.charAt(right));
            rev.setCharAt(right, ch);
            left++;
            right--;
        }
    }
    public int lcs(String s, StringBuilder rev, int m, int n, int[][] memo) {
        if(m == 0 || n == 0) {
            return 0;
        }
        if(memo[m][n] != -1) {
            return memo[m][n];
        }
        else {
            if(s.charAt(m - 1) == rev.charAt(n - 1)) {
                return memo[m][n] = 1 + lcs(s, rev, m - 1, n - 1, memo);
            }
            else return memo[m][n] = Math.max(lcs(s, rev, m - 1, n, memo), lcs(s, rev, m, n - 1, memo));
        }
    }
    public int minInsertions(String s) {
        StringBuilder rev = new StringBuilder(s);
        reverse(rev);
        int n = s.length();
        int[][] memo = new int[n + 1][n + 1];
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < n + 1; j++) {
                memo[i][j] = -1;
            }
        }
        return n - lcs(s, rev, n, n, memo);
    }
}