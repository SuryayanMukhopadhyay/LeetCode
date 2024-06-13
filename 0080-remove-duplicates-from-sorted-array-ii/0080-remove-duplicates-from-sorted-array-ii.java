class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 0, i = 0;
        while(i < n) {
            int count = 1;
            while((i + 1 < n) && (nums[i] == nums[i + 1])) {
                i++;
                count++;
            }
            for(int j = 0; j < Math.min(2, count); j++) {
                nums[left] = nums[i];
                left++;
            }
            i++;

        }
        return left;
    }
}