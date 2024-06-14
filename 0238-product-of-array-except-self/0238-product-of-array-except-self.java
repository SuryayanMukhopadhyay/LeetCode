class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] p = new int[n];
        p[0] = 1;
        int[] s = new int[n];
        s[n-1] = 1;
        int i=1, j=n-2;
        while(i<n && j>=0)
        {
            p[i] = p[i-1]*nums[i-1];
            s[j] = s[j+1]*nums[j+1];
            i++;
            j--;
        }
        i=0;
        while(i<n)
        {
            nums[i] = p[i]*s[i];
            i++;
        }
        return nums;
    }
}