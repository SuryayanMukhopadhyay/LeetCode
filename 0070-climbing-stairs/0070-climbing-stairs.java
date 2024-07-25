class Solution {
    public static int helper(int n, int[] memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if(memo[n] != 46) return memo[n];
        else {
            return memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        }
    }
    public int climbStairs(int n) {
        int[] memo = new int[46];
        Arrays.fill(memo, 46);
        return helper(n, memo);
    }
}