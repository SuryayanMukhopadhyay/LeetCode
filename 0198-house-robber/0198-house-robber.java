class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for(int i = 1; i < n; i++) {
            memo[i + 1] = Math.max(memo[i - 1] + nums[i], memo[i]);
        }
        return memo[n];
    }
}