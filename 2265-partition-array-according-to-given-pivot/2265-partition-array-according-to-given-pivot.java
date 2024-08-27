class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int less = 0, equal = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] < pivot) {
                less++;
            }
            else if(nums[i] == pivot) {
                equal++;
            }
        }
        int l = 0, g = less + equal, e = less;
        int i = 0;
        int[] res = new int[n];
        while(i < n) {
            if(nums[i] < pivot) {
                res[l] = nums[i];
                l++;
            }
            else if(nums[i] == pivot) {
                res[e] = nums[i];
                e++;
            }
            else {
                res[g] = nums[i];
                g++;
            }
            i++;
        }
        return res;
    }
}