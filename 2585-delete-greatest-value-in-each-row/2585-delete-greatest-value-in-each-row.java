class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        PriorityQueue<Integer>[] PQ = new PriorityQueue[n];
        for(int i = 0; i < n; i++) {
            PQ[i] = new PriorityQueue<>((x, y) -> y - x);
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                PQ[i].offer(grid[i][j]);
            }
        }
        int ans = 0;
        for(int i = 0; i < m; i++) {
            int max = 0;
            for(int j = 0; j < n; j++) {
                max = Math.max(max, PQ[j].peek());
                PQ[j].poll();
            }
            ans += max;
        }
        return ans;
    }
}