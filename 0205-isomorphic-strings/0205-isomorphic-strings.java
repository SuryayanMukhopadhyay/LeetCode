class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length(), m = t.length();
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)) {
                if(map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
            }
            else {
                if(map.get(ch) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;       
    }
}