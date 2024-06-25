class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        int minSum = 0;
        for(int i = 0; i < n; i++) {
            int left = i + 1, right = n - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > target) {
                    right--;
                    if(sum - target < diff) {
                        minSum = sum;
                        diff = sum - target;
                    }
                }
                else if(sum < target){
                    left++;
                    if(target - sum < diff) {
                        minSum = sum;
                        diff = target - sum;
                    }
                }
                else {
                    return target;
                }
            }
        }
        return minSum;
    }
}