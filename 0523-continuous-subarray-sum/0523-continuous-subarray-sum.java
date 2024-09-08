class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int prefix = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            prefix += nums[i];
            prefix %= k;
            if(prefix == 0 && i > 0) {
                return true;
            }
            if(map.containsKey(prefix) && i - map.get(prefix) > 1) {
                return true;
            }
            else if(!map.containsKey(prefix)) {
                map.put(prefix, i);
            }
        }
        return false;
    }
}