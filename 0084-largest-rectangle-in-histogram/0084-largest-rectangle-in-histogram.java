class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        Stack<int[]> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek()[0] >= heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                nse[i] = n;
            }
            else {
                nse[i] = stack.peek()[1];
            }
            stack.push(new int[] {heights[i], i});
        }
        stack.clear();
        int[] pse = new int[n];
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && stack.peek()[0] >= heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                pse[i] = -1;
            }
            else {
                pse[i] = stack.peek()[1];
            }
            stack.push(new int[] {heights[i], i});
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, heights[i] * (nse[i] - pse[i] - 1));
        }
        return max;
    }
}