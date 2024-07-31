class Solution {
    public void helper(int[] nums, int idx, Set<List<Integer>> set, List<Integer> temp) {
        if(idx == nums.length) {
            set.add(new ArrayList<>(temp));
            return;
        }
        helper(nums, idx + 1, set, temp);
        temp.add(nums[idx]);
        helper(nums, idx + 1, set, temp);
        temp.remove(temp.size() - 1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, set, temp);
        list.addAll(set);
        return list;
    }
}