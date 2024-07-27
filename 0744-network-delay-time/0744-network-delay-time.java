class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] delay = new int[n + 1];
        Arrays.fill(delay, (int)(1e9));
        int V = times.length;
        PriorityQueue<int[]> PQ = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        PQ.offer(new int[] {k, 0});
        delay[k] = 0;
        while(!PQ.isEmpty()) {
            int[] temp = PQ.poll();
            int node = temp[0];
            for(int i = 0; i < V; i++) {
                if(times[i][0] == node) {
                    if(delay[node] + times[i][2] < delay[times[i][1]]) {
                        delay[times[i][1]] = delay[node] + times[i][2];
                        PQ.offer(new int[] {times[i][1], delay[times[i][1]]});
                    }
                }
            }
        }
        int total = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            total = Math.max(total, delay[i]);
            if(delay[i] == (int)(1e9)) return -1;
        }
        return total;
    }
}