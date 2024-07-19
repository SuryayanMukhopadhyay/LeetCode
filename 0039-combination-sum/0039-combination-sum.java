class Solution {
    public static void helper(int[] candidates, int idx, int target, int n, List<List<Integer>> list,
            List<Integer> tempList) {
        if (idx == n) {
            if (target == 0) {
                list.add(new ArrayList<>(tempList));
            }
            return;
        }
        if(candidates[idx] <= target) {
            tempList.add(candidates[idx]);
            helper(candidates, idx, target - candidates[idx], n, list, tempList);
            tempList.remove(tempList.size() - 1);
        }
        helper(candidates, idx + 1, target, n, list, tempList);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        helper(candidates, 0, target, n, list, tempList);
        return list;
    }
}