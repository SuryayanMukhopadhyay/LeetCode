class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, candidate = nums[0];
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            if(count == 0) {
                candidate = nums[i];
            }
            if(nums[i] == candidate) {
                count++;
            }
            else {
                count--;
            }
        }
        return candidate;
    }
}