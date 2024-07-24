class Solution {
    static ArrayList<String> set = new ArrayList<>() {{
        add(""); add(""); add("abc"); add("def"); add("ghi"); add("jkl"); add("mno"); add("pqrs"); add("tuv"); add("wxyz");}};
    public static void helper(int[] arr, int n, List<String> list, String str, int idx) {
        if(idx == n) {
            list.add(str);
            return; 
        }
        for(int i = 0; i < set.get(arr[idx]).length(); i++) {
            String newStr = str + set.get(arr[idx]).charAt(i);
            helper(arr, n, list, newStr, idx + 1);
        }
        
    }
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if(n == 0) {
            return new ArrayList<String>();
        }
        List<String> list = new ArrayList<>();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = (int)digits.charAt(i) - 48;
        }
        helper(arr, n, list, "", 0);
        return list;
    }
}