class Solution {
    public int findCount(int[] nums, int n, int goal) {
        if(goal < 0) return 0;
        int sum = 0;
        int left = 0, right = 0, count = 0;
        while(right < n) {
            sum += nums[right];
            while(sum > goal) {
                sum -= nums[left];
                left++;
            }
            count += (right - left) + 1;
            right++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        return findCount(nums, n, goal) - findCount(nums, n, goal - 1);
    }
}