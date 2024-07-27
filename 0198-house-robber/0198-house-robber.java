class Solution {
    int[] memo = new int[100];
    int rob(int[] nums, int idx) {
        if(idx < 0) {
            return 0;
        }
        if(memo[idx] != -1) {
            return memo[idx];
        }
        return memo[idx] = Math.max(rob(nums, idx - 2) + nums[idx], rob(nums, idx - 1));
    }
    public int rob(int[] nums) {
        int n = nums.length;
        Arrays.fill(memo, -1);
        return rob(nums, n - 1);
    }
}