class Solution {
    public static void helper(int[] nums, int n, int idx, List<Integer> tempList, List<List<Integer>> list) {
        if(idx == n) {
            list.add(tempList);
            return;
        }
        helper(nums, n, idx + 1, tempList, list);
        List<Integer> newList = new ArrayList<>();
        newList.addAll(tempList);
        newList.add(nums[idx]);
        helper(nums, n, idx + 1, newList, list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        List<Integer> tempList = new ArrayList<>();
        helper(nums, n, 0, tempList, list);
        return list;
    }
}