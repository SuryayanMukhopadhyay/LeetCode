class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums1.length;
        for(int i = 0; i < n; i++) {
            map.put(nums1[i], i);
        }
        int[] res = new int[n];
        n = nums2.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            if(map.containsKey(nums2[i])) {
                while(!stack.isEmpty() && stack.peek() <= nums2[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    res[map.get(nums2[i])] = -1;
                }
                else {
                    res[map.get(nums2[i])] = stack.peek();
                }
                stack.push(nums2[i]);
            }
            else {
                stack.push(nums2[i]);
            }
        }
        return res;
    }
}