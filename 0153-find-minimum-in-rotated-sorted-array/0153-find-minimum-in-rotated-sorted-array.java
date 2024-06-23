class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(nums[0]<nums[n-1]) return nums[0];
        int l = 0, r = n-1;
        int min = nums[0];
        while(l<=r){
            int m = (l+r)/2;
            min = Math.min(Math.min(Math.min(nums[l], nums[m]), nums[r]), min);
            if(nums[l]<=nums[m]){
                l = m + 1;
            }
            else
            {
                r = m - 1;
            }
        }
        return min;
    }
}