class NumArray {
    int[] nums;
    int[] prefix;
    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        prefix = new int[n + 1];
        prefix[0] = 0;
        prefix[1] = nums[0];
        for(int i = 1; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */