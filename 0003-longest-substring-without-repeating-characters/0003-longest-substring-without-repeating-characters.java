class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int start = 0, end = 0;
        int n = s.length();
        int max = Integer.MIN_VALUE;
        while (end < n) {
            char ch = s.charAt(end);
            if (!set.add(ch)) {
                max = Math.max(max, end - start);
                while (!set.add(ch)) {
                    set.remove(s.charAt(start));
                    start++;
                }
            }
            end++;
        }
        max = Math.max(max, end - start);
        return max;
    }
}