class Solution {
    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, mid = 0;
        while(mid <= right) {
            if(nums[mid] == 0) {
                swap(nums, left, mid);
                left++;
                mid++;
            }
            else if(nums[mid] == 1) {
                mid++;
            }
            else {
                swap(nums, mid, right);
                right--;
            }
        }
    }
}