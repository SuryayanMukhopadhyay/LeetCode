class Solution {
    public void findCount(int[][] land, int i, int j, int m, int n, boolean[][] visited) {
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) {
            return;
        }
        if (land[i][j] != 1 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        findCount(land, i + 1, j, m, n, visited);
        findCount(land, i - 1, j, m, n, visited);
        findCount(land, i, j + 1, m, n, visited);
        findCount(land, i, j - 1, m, n, visited);
    }

    public void dfs(int[][] land, int i, int j, int m, int n, boolean[][] visited, int[] arr) {
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) {
            return;
        }
        if (land[i][j] != 1 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if(arr[0] <= i && arr[1] <= j) {
            arr[0] = i;
            arr[1] = j;
        }
        if(arr[2] >= i && arr[3] >= j) {
            arr[2] = i;
            arr[3] = j;
        }
        dfs(land, i + 1, j, m, n, visited, arr);
        dfs(land, i - 1, j, m, n, visited, arr);
        dfs(land, i, j + 1, m, n, visited, arr);
        dfs(land, i, j - 1, m, n, visited, arr);
    }

    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    count++;
                    findCount(land, i, j, m, n, visited);
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        int[][] mat = new int[count][4];
        int k = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    int[] arr = new int[]{0, 0, m, n};
                    dfs(land, i, j, m, n, visited, arr);
                    mat[k][0] = arr[2];
                    mat[k][1] = arr[3];
                    mat[k][2] = arr[0];
                    mat[k][3] = arr[1];
                    k++;
                }
            }
        }
        return mat;
    }
}