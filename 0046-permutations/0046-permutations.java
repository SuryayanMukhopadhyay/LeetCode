class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void helper(int[] nums, int idx, int n) {
        if(idx == n) {
            list.add(IntStream.of(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for(int i = idx; i < n; i++) {
            swap(nums, idx, i);
            helper(nums, idx + 1, n);
            swap(nums, idx, i);
        }
        return;
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        helper(nums, 0, n);
        return list;
    }
}