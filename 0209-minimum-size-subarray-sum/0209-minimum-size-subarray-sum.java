class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int start = 0, i = 0;
        int prefix = 0, len = 0, min = Integer.MAX_VALUE;
        while(i < n) {
            if(nums[i] == target) return 1;
            prefix += nums[i];
            if(prefix == target) {
                len = (i - start) + 1;
                min = Math.min(min, len);
                i++;
            }
            else if(prefix >= target) {
                prefix = (prefix - nums[start]) - nums[i];
                len = (i - start) + 1;
                min = Math.min(min, len);
                start++;
            }
            else {
                i++;
            }
        }
        min = Math.min(min, len);
        return min;
    }
}