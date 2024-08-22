class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = (int)(1e9);
            }
        }
        for(int i = 0; i < n; i++) {
            matrix[i][i] = 0;
        }
        int m = edges.length;
        for(int i = 0; i < m; i++) {
            matrix[edges[i][0]][edges[i][1]] = edges[i][2];
            matrix[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        for(int via = 0; via < n; via++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(matrix[i][via] == (int)(1e9) || matrix[via][j] == (int)(1e9)) {
                        continue;
                    }
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }
        int cntCity = n;
        int cityNo = -1;
        for(int city = 0; city < n; city++) {
            int cnt = 0;
            for(int adjCity = 0; adjCity < n; adjCity++) {
                if(matrix[city][adjCity] <= distanceThreshold) {
                    cnt++;
                }
            }
            if(cnt <= cntCity) {
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }
}