class Solution {
    public boolean checkFreq(int[] freq, int[] temp, String str) {
        int n = str.length();
        for(int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            temp[ch - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(freq[i] != temp[i]) {
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        int m = s1.length(), n = s2.length();
        for(int i = 0; i < m; i++) {
            char ch = s1.charAt(i);
            freq[ch - 'a']++;
        }
        int left = 0, right = m - 1;
        while(right < n) {
            int[] temp = new int[26];
            if(checkFreq(freq, temp, s2.substring(left, right + 1))) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }
}