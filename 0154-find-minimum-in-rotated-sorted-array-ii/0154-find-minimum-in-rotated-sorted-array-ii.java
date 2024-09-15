// Beats 100 % (Linear Time)
// class Solution {
//     public int findMin(int[] nums) {
//         int min = Integer.MAX_VALUE;
//         for(int num : nums) {
//             min = Math.min(min, num);
//         }
//         return min;
//     }
// }
class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        
        if (nums[lo] < nums[hi]) return nums[lo];
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                hi--;
            }
        }
        
        return nums[hi];
    }
}