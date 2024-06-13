class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0, n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] > nums[left]) {
                left++;
                nums[left] = nums[i];
            }
        }
        return left + 1;
    }
}