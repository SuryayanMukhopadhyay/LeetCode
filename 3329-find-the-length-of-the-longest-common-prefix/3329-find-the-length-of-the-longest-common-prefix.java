class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();
        for(int num : arr1) {
            String s = Integer.toString(num);
            int n = s.length();
            StringBuilder str = new StringBuilder("");
            for(int i = 0; i < n; i++) {
                str.append(s.charAt(i));
                set.add(str.toString());
            }
        }
        int max = 0;
        for(int num : arr2) {
            String s = Integer.toString(num);
            int n = s.length();
            StringBuilder str = new StringBuilder("");
            for(int i = 0; i < n; i++) {
                str.append(s.charAt(i));
                if(set.contains(str.toString())) {
                    max = Math.max(max, str.length());
                }
            }
        }
        return max;
    }
}