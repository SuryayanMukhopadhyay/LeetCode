class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int max = Integer.MIN_VALUE, mul = 0;
        while(left < right) {
            mul = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(mul, max);
            if(height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        mul = Math.min(height[left], height[right]) * (right - left);
        max = Math.max(mul, max);
        return max;
    }
}