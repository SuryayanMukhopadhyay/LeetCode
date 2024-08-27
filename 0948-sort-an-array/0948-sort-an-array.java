class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> PQ = new PriorityQueue<>((x, y) -> x - y);
        for(int num : nums) {
            PQ.offer(num);
        }
        int i = 0;
        while(!PQ.isEmpty()) {
            nums[i] = PQ.poll();
            i++;
        }
        return nums;
    }
}