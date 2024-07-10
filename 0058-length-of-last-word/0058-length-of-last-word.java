class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int i = s.length() - 1;
        while(i >= 0) {
            if(s.charAt(i) == ' ') {
                i++;
                break;
            }
            i--;
        }
        if(i == -1) {
            return s.length();
        }
        s = s.substring(i, s.length());
        return s.length();
    }
}