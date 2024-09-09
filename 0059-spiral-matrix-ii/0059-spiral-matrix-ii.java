class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int bottom = n, right = n;
        int left = 0, top = 0;
        int x = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                matrix[top][i] = x;
                x++;
            }
            top++;
            for (int i = top; i < bottom; i++) {
                matrix[i][right - 1] = x;
                x++;
            }
            right--;
            if (!(left < right) && !(top < bottom)) {
                break;
            }
            if (top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    matrix[bottom - 1][i] = x;
                    x++;
                }
            }
            bottom--;
            if (left < right) {
                for (int i = bottom - 1; i >= top; i--) {
                    matrix[i][left] = x;
                    x++;
                }
            }
            left++;
        }
        return matrix;
    }
}