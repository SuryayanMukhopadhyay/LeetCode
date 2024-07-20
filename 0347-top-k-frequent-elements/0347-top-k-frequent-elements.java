class Pair {
    int element;
    int frequency;
    Pair(int _element, int _frequency) {
        this.element = _element;
        this.frequency = _frequency;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
            else {
                int count = map.get(nums[i]);
                count++;
                map.remove(nums[i]);
                map.put(nums[i], count);
            }
        }
        PriorityQueue<Pair> PQ = new PriorityQueue<>((x, y) -> y.frequency - x.frequency);
        for(int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                PQ.offer(new Pair(nums[i], count));
                map.remove(nums[i]);
            }
        }
        for(int i = 0; i < k; i++) {
            Pair temp = PQ.poll();
            int elem = temp.element;
            res[i] = elem;
        }
        return res;
    }
}