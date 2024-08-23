class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] edges = new int[n];
        int m = roads.length;
        Arrays.fill(edges, 0);
        for(int i = 0; i < m; i++) {
            edges[roads[i][0]]++;
            edges[roads[i][1]]++;
        }
        PriorityQueue<int[]> PQ = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        for(int i = 0; i < n; i++) {
            PQ.offer(new int[] {i, edges[i]});
        }
        int priority = 1;
        while(!PQ.isEmpty()) {
            int[] temp = PQ.poll();
            edges[temp[0]] = priority;
            priority++;
        }
        long max = 0;
        for(int i = 0; i < m; i++) {
            max = max + edges[roads[i][0]];
            max = max + edges[roads[i][1]];
        }
        return max;
    }
}