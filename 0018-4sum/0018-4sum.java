class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        if(target >= Integer.MAX_VALUE || target <= Integer.MIN_VALUE) return list;
        for(int i = 0; i < n-3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            else if(nums[i] >= Integer.MAX_VALUE || nums[i] <= Integer.MIN_VALUE) {
                continue;
            }
            else {
                for(int j = i + 1; j < n-2; j++) {
                    if(j > i + 1 && nums[j] == nums[j-1]) {
                        continue;
                    }
                    else {
                        int left = j + 1, right = n - 1;
                        while(left < right) {
                            long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                            if(sum == target) {
                                set.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                                right--;
                                left++;
                            }
                            else if(sum > target) {
                                right--;
                            }
                            else {
                                left++;
                            }
                        }
                    }
                }
            }
        }
        list.addAll(set);
        return list;
    }
}

