class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            else {
                int left = i + 1, right = n - 1;
                while(left < right) {
                    if(nums[i] + nums[left] + nums[right] > 0) {
                        right--;
                    }
                    else if(nums[i] + nums[left] + nums[right] < 0) {
                        left++;
                    }
                    else {
                        set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                    }
                }
            }
        }
        list.addAll(set);
        return list;
    }
}