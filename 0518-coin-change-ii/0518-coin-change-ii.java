class Solution {
    public int change(int amount, int[] coins, int idx, int[][] memo) {
        if(amount == 0) {
            return 1;
        }
        if(amount < 0) {
            return 0;
        }
        if(idx == coins.length) {
            return 0;
        }
        if(memo[idx][amount] != -1) {
            return memo[idx][amount];
        }
        return memo[idx][amount] = change(amount - coins[idx], coins, idx, memo) + change(amount, coins, idx + 1, memo);
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] memo = new int[n + 1][amount + 1];
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < amount + 1; j++) {
                memo[i][j] = -1;
            }
        }
        return change(amount, coins, 0, memo);
    }
}