class Solution {
    public int findCount(int[] nums, int n, int k) {
        if(k < 0) return 0;
        int left = 0, right = 0, sum = 0, count = 0;
        while(right < n) {
            sum += nums[right] % 2;
            while(sum > k) {
                sum -= nums[left] % 2;
                left++;
            }
            count += (right - left) + 1;
            right++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        return findCount(nums, n, k) - findCount(nums, n, k - 1);
    }
}