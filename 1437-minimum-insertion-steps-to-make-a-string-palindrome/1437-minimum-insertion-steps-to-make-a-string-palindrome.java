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
    public int minInsertions(String s) {
        StringBuilder rev = new StringBuilder(s);
        reverse(rev);
        int n = s.length();
        int[][] memo = new int[n + 1][n + 1];
        for(int i = 0; i < n + 1; i++) {
            memo[i][0] = 0;
        }
        for(int i = 0; i < n + 1; i++) {
            memo[0][i] = 0;
        }
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(s.charAt(i - 1) == rev.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                }
                else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        return n - memo[n][n];
    }
}