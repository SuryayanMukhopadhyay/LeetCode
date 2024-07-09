class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a,b)->b-a);
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            PQ.add(nums[i]);
        }
        int f = k - 1;
        while(f > 0) {
            PQ.remove();
            f--;
        } 
        return PQ.peek();
    }
}