class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int jumps = 0;
        int left = 0, right = 0;
        while(right < n - 1) {
            int farthest = 0;
            for(int i = left; i < right + 1; i++) {
                farthest = Math.max(farthest, nums[i] + i);
            }
            left = right + 1;
            right = farthest;
            jumps++;
        }
        return jumps;
    }
}