class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length, c = heights[0].length;
        int[][] dist = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                dist[i][j] = (int)(1e9);
            }
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> PQ = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        PQ.offer(new int[] {0, 0, 0});
        int effort = Integer.MAX_VALUE;
        while(!PQ.isEmpty()) {
            int[] temp = PQ.peek();
            PQ.poll();
            int diff = temp[0];
            int i = temp[1];
            int j = temp[2];
            if(i == r - 1 && j == c - 1) {
                effort = Math.min(effort, diff);
            }
            if(i < r - 1 && Math.abs(heights[i + 1][j] - heights[i][j]) < dist[i + 1][j]) {
                dist[i + 1][j] = Math.abs(heights[i + 1][j] - heights[i][j]);
                PQ.offer(new int[] {Math.abs(heights[i + 1][j] - heights[i][j]), i + 1, j});
            }
            if(i > 0 && Math.abs(heights[i - 1][j] - heights[i][j]) < dist[i - 1][j]) {
                dist[i - 1][j] = Math.abs(heights[i - 1][j] - heights[i][j]);
                PQ.offer(new int[] {Math.abs(heights[i - 1][j] - heights[i][j]), i - 1, j});
            }
            if(j < c - 1 && Math.abs(heights[i][j + 1] - heights[i][j]) < dist[i][j + 1]) {
                dist[i][j + 1] = Math.abs(heights[i][j + 1] - heights[i][j]);
                PQ.offer(new int[] {Math.abs(heights[i][j + 1] - heights[i][j]), i, j + 1});
            }
            if(j > 0 && Math.abs(heights[i][j - 1] - heights[i][j]) < dist[i][j - 1]) {
                dist[i][j - 1] = Math.abs(heights[i][j - 1] - heights[i][j]);
                PQ.offer(new int[] {Math.abs(heights[i][j - 1] - heights[i][j]), i, j - 1});
            }
        }
        return effort;
    }
}