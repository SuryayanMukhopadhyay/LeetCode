class Solution {
    public long maxSpending(int[][] values) {
        int m = values.length, n = values[0].length;
        PriorityQueue<Long> PQ = new PriorityQueue<>((x, y) -> Long.compare(x, y));
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                PQ.offer((long)values[i][j]);
            }
        }
        long max = 0;
        int size = m * n;
        for(long i = 1; i <= size; i++) {
            max += PQ.poll() * i;
        }
        return max;
    }
}