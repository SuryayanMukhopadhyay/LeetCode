class NumMatrix {
    int[][] matrix;
    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length, n = matrix[0].length;
        prefix = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++) {
            prefix[i][0] = 0;
        }
        for(int i = 0; i < n; i++) {
            prefix[0][i] = 0;
        }
        int prev = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                prefix[i + 1][j + 1] = prev + matrix[i][j];
                prev = prefix[i + 1][j + 1];
            }
            prev = 0;
        }
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                System.out.print(prefix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int row = row1; row <= row2; row++) {
            sum += prefix[row + 1][col2 + 1] - prefix[row + 1][col1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */