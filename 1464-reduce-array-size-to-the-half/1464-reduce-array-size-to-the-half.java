class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            }
            else {
                int freq = map.get(arr[i]);
                map.remove(arr[i]);
                map.put(arr[i], freq + 1);
            }
        }
        PriorityQueue<Integer> PQ = new PriorityQueue<>((x, y) -> y - x);
        for(int i = 0; i < n; i++) {
            if(map.containsKey(arr[i])) {
                PQ.offer(map.get(arr[i]));
                map.remove(arr[i]);
            }
        }
        int size = 0;
        int half = 0;
        while(!PQ.isEmpty()) {
            half = half + PQ.poll();
            size++;
            if(half >= (n / 2)) {
                break;
            }
        }
        return size;
    }
}