class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int bottom = matrix.length, right = matrix[0].length;
        int left = 0, top = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i < bottom; i++) {
                list.add(matrix[i][right - 1]);
            }
            right--;
            if (!(left < right) && !(top < bottom)) {
                break;
            }
            if (top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    list.add(matrix[bottom - 1][i]);
                }
            }
            bottom--;
            if (left < right) {
                for (int i = bottom - 1; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
        }
        return list;
    }
}