class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length, m = queries.length;
        int[] xor = new int[n + 1];
        xor[0] = 0;
        xor[1] = arr[0];
        for(int i = 1; i < n; i++) {
            xor[i + 1] = xor[i] ^ arr[i];
        }
        int[] res = new int[m];
        for(int i = 0; i < m; i++) {
            int low = queries[i][0];
            int hi = queries[i][1];
            res[i] = xor[hi + 1] ^ xor[low];
        }
        return res;
    }
}