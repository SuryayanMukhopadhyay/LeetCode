class Solution {
    public void scs(String str1, String str2, int m, int n, int[][] memo) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = i + j;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = 1 + Math.min(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] memo = new int[m + 1][n + 1];
        scs(str1, str2, m, n, memo);
        int i = m, j = n;
        StringBuilder result = new StringBuilder("");
        while(i > 0 && j > 0) {
            if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                result.append(str1.charAt(i - 1));
                i--;
                j--;
            }
            else if(memo[i - 1][j] < memo[i][j - 1]) {
                result.append(str1.charAt(i - 1));
                i--;
            }
            else {
                result.append(str2.charAt(j - 1));
                j--;
            }
        }
        while(i > 0) {
            result.append(str1.charAt(i - 1));
            i--;
        }
        while(j > 0) {
            result.append(str2.charAt(j - 1));
            j--;
        }
        result = result.reverse();
        return result.toString();
    }
}