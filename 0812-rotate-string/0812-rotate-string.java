class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length(), m = goal.length();
        if(n!=m) return false;
        if(s.equals(goal)) return true;
        StringBuilder str = new StringBuilder(s);
        for(int i = 0; i < n; i++) {
            str.delete(0, 1);
            str.append(s.charAt(i));
            if(str.toString().equals(goal)) return true;
        }
        return false;
    }
}