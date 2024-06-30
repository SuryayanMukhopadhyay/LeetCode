class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int idx = 0;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[mid]<target)
            {
                l = mid+1;
                idx = mid+1;
            }
            else
            {
                r = mid-1;
                idx = mid;
            }
        }
        if(idx<0) return 0;
        return idx;
    }
}