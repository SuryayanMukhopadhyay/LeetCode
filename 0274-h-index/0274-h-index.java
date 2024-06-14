class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if(n == 1) return Math.min(citations[0], 1);
        int count = 1, res = 0;
        Arrays.sort(citations);
        for(int i = n - 1; i >= 0; i--, count++) {
            if(count > citations[i])  {
                return count - 1;
            }
        }
        return n;
    }
}