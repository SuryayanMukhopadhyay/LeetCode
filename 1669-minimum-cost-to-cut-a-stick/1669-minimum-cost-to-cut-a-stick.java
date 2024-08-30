class Solution {
    public int mcm(int[] cut, int i, int j, int[][] memo) {
        if(i > j) {
            return 0;
        }
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++) {
            int part1 = mcm(cut, i, k - 1, memo);
            int part2 = mcm(cut, k + 1, j, memo);
            int cost = cut[j + 1] - cut[i - 1];
            min = Math.min(min, (part1 + part2 + cost));
        }
        return memo[i][j] = min;
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int size = cuts.length;
        int[] cut = new int[size + 2];
        cut[0] = 0;
        for(int i = 1; i < size + 1; i++) {
            cut[i] = cuts[i - 1];
        }
        cut[size + 1] = n;
        int[][] memo = new int[size + 1][size + 1];
        for(int i = 0; i <= size; i++) {
            for(int j = 0; j <= size; j++) {
                memo[i][j] = -1;
            }
        }
        return mcm(cut, 1, size, memo);
    }
}