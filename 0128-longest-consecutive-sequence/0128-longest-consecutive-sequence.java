class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        if (n == 0 || n == 1)
            return n;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(!set.contains(nums[i] - 1)) {
                int j = 1, len = 1;
                while(set.contains(nums[i] + j)) {
                    j++;
                    len++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}