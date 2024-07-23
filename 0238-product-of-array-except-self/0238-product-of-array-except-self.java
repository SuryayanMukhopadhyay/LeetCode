// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n = nums.length;
//         int[] p = new int[n];
//         p[0] = 1;
//         int[] s = new int[n];
//         s[n-1] = 1;
//         int i=1, j=n-2;
//         while(i<n && j>=0)
//         {
//             p[i] = p[i-1]*nums[i-1];
//             s[j] = s[j+1]*nums[j+1];
//             i++;
//             j--;
//         }
//         i=0;
//         while(i<n)
//         {
//             nums[i] = p[i]*s[i];
//             i++;
//         }
//         return nums;
//     }
// }
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }
}