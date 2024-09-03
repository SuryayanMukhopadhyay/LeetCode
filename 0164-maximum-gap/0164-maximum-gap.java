class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return 0;
        }
        if(n == 2) {
            return Math.abs(nums[0] - nums[1]);
        }
        PriorityQueue<Integer> PQ = new PriorityQueue<>((x, y) -> x - y);
        for(int i = 0; i < n; i++) {
            PQ.offer(nums[i]);
        }
        int diff = Integer.MIN_VALUE;
        int prev = -1;
        while(!PQ.isEmpty()) {
            if(prev == -1) {
                prev = PQ.poll();
                continue;
            }
            else {
                int temp = PQ.poll();
                diff = Math.max(diff, Math.abs(prev - temp));
                prev = temp;
            }
        }   
        return diff;
    }
}