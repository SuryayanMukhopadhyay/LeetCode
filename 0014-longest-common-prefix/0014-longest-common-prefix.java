class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        StringBuilder str = new StringBuilder(strs[0]);
        int m = str.length();
        for(String s : strs) {
            int n = s.length();
            int i = 0;
            while(i < n && i < m) {
                if(str.charAt(i) == s.charAt(i)) {
                    i++;
                }
                else {
                    break;
                }
            }
            str.setLength(i);
            m = i;
        }
        return str.toString();
    }
}