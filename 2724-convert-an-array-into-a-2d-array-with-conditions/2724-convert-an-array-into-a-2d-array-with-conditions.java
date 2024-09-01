class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        int j = -1;
        for(int i = 0; i < n; i++) {
            int size = list.size();
            boolean added = false;
            for(int k = 0; k < size; k++) {
                if(!list.get(k).contains(nums[i])) {
                    list.get(k).add(nums[i]);
                    added = true;
                    break;
                }
            }
            if(!added) {
                list.add(new ArrayList<>());
                j++;
                list.get(j).add(nums[i]);
            }
        }
        return list;
    }
}