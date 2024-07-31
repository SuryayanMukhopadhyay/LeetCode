class Solution {
    public int helper(int[] nums, int idx, int target, int[] memo) {
        if(idx == nums.length) {
            if(target == 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
        if(memo[idx] < (int)(1e9)) {
            return memo[target];
        }
        return helper(nums, idx + 1, target + nums[idx], memo) + helper(nums, idx + 1, target - nums[idx], memo);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int[] memo = new int[21];
        Arrays.fill(memo, (int)(1e9));
        return helper(nums, 0, target, memo);
    }
}