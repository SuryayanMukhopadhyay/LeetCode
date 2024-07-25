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
        int[] dr = { 0, 0, -1, 1 };
        int[] dc = { -1, 1, 0, 0 };
        while(!PQ.isEmpty()) {
            int[] temp = PQ.peek();
            PQ.poll();
            int diff = temp[0];
            int i = temp[1];
            int j = temp[2];
            if(i == r - 1 && j == c - 1) {
                return diff;
            }
            for(int k = 0; k < 4; k++) {
                int newrow = i + dr[k];
                int newcol = j + dc[k];
                if(newrow >= 0 && newcol >= 0 && newrow < r && newcol < c) {
                    int effort = Math.max(Math.abs(heights[i][j] - heights[newrow][newcol]), diff);
                    if(effort < dist[newrow][newcol]) {
                        PQ.offer(new int[] {effort, newrow, newcol});
                        dist[newrow][newcol] = effort;
                    }
                }
            }
        }
        return 0;
    }
}