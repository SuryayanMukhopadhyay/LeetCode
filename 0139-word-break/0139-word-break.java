class Solution {
    public boolean helper(String s, HashSet<String> set, int idx, int n, int[] memo) {
        if(idx == n) {
            return true;
        }
        if(memo[idx] == 0) {
            return false;
        }
        if(memo[idx] == 1) {
            return true;
        }
        StringBuilder temp = new StringBuilder("");
        for(int i = idx; i < n; i++) {
            temp.append(s.charAt(i));
            if(set.contains(temp.toString())) {
                if(helper(s, set, i + 1, n, memo)) {
                    memo[idx] = 1;
                    return true;
                }
                else {
                    memo[idx] = 0;
                }
            }
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int size = wordDict.size();
        for(int i = 0; i < size; i++) {
            set.add(wordDict.get(i));
        }
        int n = s.length();
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return helper(s, set, 0, n, memo);
    }
}