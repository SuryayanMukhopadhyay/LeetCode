class Solution {
    public boolean subset(int[] nums, int n, int sum) {
        boolean[][] memo = new boolean[n + 1][sum + 1];
        for(int i = 0; i < sum + 1; i++) {
            memo[0][i] = false;
        }
        for(int i = 0; i < n + 1; i++) {
            memo[i][0] = true;
        }
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                if(nums[i - 1] <= j) {
                    memo[i][j] = memo[i - 1][j - nums[i - 1]] || memo[i - 1][j];
                }
                else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }
        return memo[n][sum];
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0) {
            return false;
        }
        else {
            return subset(nums, n - 1, sum / 2);
        }
    }
}