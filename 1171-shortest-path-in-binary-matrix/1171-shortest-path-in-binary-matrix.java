class Values {
    int ival;
    int jval;
    int count;

    Values(int _ival, int _jval, int _count) {
        this.ival = _ival;
        this.jval = _jval;
        this.count = _count;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0)
            return -1;
        int n = grid.length;
        int path = Integer.MAX_VALUE;
        Queue<Values> Q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        Q.offer(new Values(0, 0, 0));
        visited[0][0] = true;
        boolean found = false;
        while (!Q.isEmpty()) {
            Values temp = Q.poll();
            int i = temp.ival;
            int j = temp.jval;
            int cnt = temp.count;
            if(i == n - 1 && j == n - 1) {
                path = Math.min(path, cnt);
                found = true;
            } 
            if (i > 0) {
                if (grid[i - 1][j] == 0 && !visited[i - 1][j]) {
                    Q.offer(new Values(i - 1, j, cnt + 1));
                    visited[i - 1][j] = true;
                }
            }
            if (i > 0 && j > 0) {
                if (grid[i - 1][j - 1] == 0 && !visited[i - 1][j - 1]) {
                    Q.offer(new Values(i - 1, j - 1, cnt + 1));
                    visited[i - 1][j - 1] = true;
                }
            }
            if (i > 0 && j < n - 1) {
                if (grid[i - 1][j + 1] == 0 && !visited[i - 1][j + 1]) {
                    Q.offer(new Values(i - 1, j + 1, cnt + 1));
                    visited[i - 1][j + 1] = true;
                }
            }
            if (i < n - 1) {
                if (grid[i + 1][j] == 0 && !visited[i + 1][j]) {
                    Q.offer(new Values(i + 1, j, cnt + 1));
                    visited[i + 1][j] = true;
                }
            }
            if (j > 0) {
                if (grid[i][j - 1] == 0 && !visited[i][j - 1]) {
                    Q.offer(new Values(i, j - 1, cnt + 1));
                    visited[i][j - 1] = true;
                }
            }
            if (j < n - 1) {
                if (grid[i][j + 1] == 0 && !visited[i][j + 1]) {
                    Q.offer(new Values(i, j + 1, cnt + 1));
                    visited[i][j + 1] = true;
                }
            }
            if (i < n - 1 && j < n - 1) {
                if (grid[i + 1][j + 1] == 0 && !visited[i + 1][j + 1]) {
                    Q.offer(new Values(i + 1, j + 1, cnt + 1));
                    visited[i + 1][j + 1] = true;
                }
            }
            if (i < n - 1 && j > 0) {
                if (grid[i + 1][j - 1] == 0 && !visited[i + 1][j - 1]) {
                    Q.offer(new Values(i + 1, j - 1, cnt + 1));
                    visited[i + 1][j - 1] = true;
                }
            }

        }
        if(found) return path + 1;
        else return -1;
    }
}