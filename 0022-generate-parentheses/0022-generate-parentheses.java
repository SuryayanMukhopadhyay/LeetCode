class Solution {
    public static void helper(int open, int close, List<String> list, String str) {
        if (open == 0 && close == 0) {
            list.add(str);
            return;
        }
        if(open != 0) {
            String newStr = str + "(";
            helper(open - 1, close, list, newStr);
        }
        if(close > open) {
            String newStr = str + ")";
            helper(open, close - 1, list, newStr);
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        int open = n, close = n;
        helper(open, close, list, "");
        return list;
    }
}