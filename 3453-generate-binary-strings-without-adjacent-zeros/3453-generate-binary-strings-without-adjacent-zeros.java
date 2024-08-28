class Solution {
    public void helper(List<String> list, StringBuilder str, int n) {
        if (n == 0) {
            String s = str.toString();
            list.add(s);
            return;
        }
        int size = str.length();
        if (size > 0) {
            if (str.charAt(size - 1) == '1') {
                StringBuilder str1 = new StringBuilder(str);
                str1.append('1');
                helper(list, str1, n - 1);
                StringBuilder str2 = new StringBuilder(str);
                str2.append('0');
                helper(list, str2, n - 1);
            } else {
                StringBuilder str1 = new StringBuilder(str);
                str1.append('1');
                helper(list, str1, n - 1);
            }
        } else {
            StringBuilder str1 = new StringBuilder(str);
            str1.append('1');
            helper(list, str1, n - 1);
            StringBuilder str2 = new StringBuilder(str);
            str2.append('0');
            helper(list, str2, n - 1);
        }
    }

    public List<String> validStrings(int n) {
        StringBuilder str = new StringBuilder("");
        List<String> list = new ArrayList<>();
        helper(list, str, n);
        return list;
    }
}