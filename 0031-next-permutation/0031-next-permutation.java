class Solution {
    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                idx = i - 1;
                break;
            }
        }
        if (idx == -1) {
            reverse(nums, 0, n - 1);
        } else {
            int smallest = Integer.MAX_VALUE, smallidx = idx;
            for (int i = idx + 1; i < n; i++) {
                if (nums[i] > nums[idx] && nums[i] <= smallest) {
                    smallest = nums[i];
                    smallidx = i;
                }
            }
            swap(nums, idx, smallidx);
            reverse(nums, idx + 1, n - 1);
        }
    }
}