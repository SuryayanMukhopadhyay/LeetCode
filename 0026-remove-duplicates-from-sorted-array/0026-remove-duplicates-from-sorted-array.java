class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0, n = nums.length, right = 0;
        while(right < n) {
            if(nums[right] > nums[left]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }
}