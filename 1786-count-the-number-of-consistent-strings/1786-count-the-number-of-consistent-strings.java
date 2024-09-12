class Solution {
    public boolean isValid(String str, HashSet<Character> set) {
        int n = str.length();
        for(int i = 0; i < n; i++) {
            if(!set.contains(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();
        int n = allowed.length();
        for(int i = 0; i < n; i++) {
            set.add(allowed.charAt(i));
        }
        int count = 0;
        for(String str : words) {
            if(isValid(str, set)) {
                count++;
            }
        }
        return count;
    }
}