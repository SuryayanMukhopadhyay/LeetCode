class Solution {
    public int strStr(String haystack, String needle) {
        int h = haystack.length(), n = needle.length();
        if(n > h) return -1;
        for(int i = 0; i < h; i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int j = 0;
                while(j < n) {
                    if(i + j >= h) {
                        break;
                    }
                    if(haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                    j++;
                }
                if(j == n) {
                    return i;
                }
            }
        }
        return -1;
    }
}