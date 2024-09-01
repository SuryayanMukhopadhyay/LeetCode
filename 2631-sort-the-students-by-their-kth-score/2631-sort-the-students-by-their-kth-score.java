class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int m = score.length, n = score[0].length;
        PriorityQueue<int[]> PQ = new PriorityQueue<>((x, y) -> y[k] - x[k]);
        for(int i = 0; i < m; i++) {
            int[] arr = new int[n];
            for(int j = 0; j < n; j++) {
                arr[j] = score[i][j];
            }
            PQ.add(arr);
        }
        int[][] res = new int[m][n];
        int i = 0;
        while(!PQ.isEmpty()) {
            int[] arr = PQ.poll();
            for(int j = 0; j < n; j++) {
                res[i][j] = arr[j];
            }
            i++;
        }
        return res;
    }
}