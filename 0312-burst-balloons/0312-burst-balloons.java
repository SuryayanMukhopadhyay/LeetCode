class Solution {
    public int mcm(int[] num, int i, int j, int[][] memo) {
        if(i > j) {
            return 0;
        }
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        int max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++) {
            int part1 = mcm(num, i, k - 1, memo);
            int part2 = mcm(num, k + 1, j, memo);
            int cost = num[i - 1] * num[k] * num[j + 1];
            max = Math.max(max, (part1 + part2 + cost));
        }
        return memo[i][j] = max;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] num = new int[n + 2];
        num[0] = 1;
        for(int i = 1; i < n + 1; i++) {
            num[i] = nums[i - 1];
        }
        num[n + 1] = 1;
        int[][] memo = new int[n + 1][n + 1];
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < n + 1; j++) {
                memo[i][j] = -1;
            }
        }
        return mcm(num, 1, n, memo);
    }
}