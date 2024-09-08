class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[n];
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                pse[i] = -1;
            }
            else {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        int[] nse = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                nse[i] = n;
            }
            else {
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        long sum = 0;
        int mod = (int)(1e9 + 7);
        for(int i = 0; i < n; i++) {
            sum += (long)(i - pse[i]) * (nse[i] - i) % mod * arr[i] % mod;
            sum %= mod;
        }
        return (int)sum;
    }
}