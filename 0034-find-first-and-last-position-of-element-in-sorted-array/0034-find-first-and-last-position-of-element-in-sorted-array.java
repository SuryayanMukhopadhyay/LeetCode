class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int first = 0, last = 0, idx = -1;
        int[] arr = new int[2];
        arr[0] = 0;
        arr[1] = 0;
        if(n == 1 && nums[0] == target) return arr;
        while (l < r) {
            if(nums[l] == target) {
                idx = l;
                break;
            }
            if(nums[r] == target) {
                idx = r;
                break;
            }
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                idx = mid;
                break;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (idx == -1) {
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }
        int i = idx;
        while(i >= 0 && nums[i] == nums[idx]) {
            i--;
        }
        arr[0] = i + 1;
        i = idx;
        while(i < n && nums[i] == nums[idx]) {
            i++;
        }
        arr[1] = i - 1;
        return arr;
    }
}