class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        List<List<Character>> list = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }
        int i = 0, n = s.length(), j = 0;
        while(i < n) {
            while(i < n && j < numRows) {
                list.get(j).add(s.charAt(i));
                i++;
                j++;
            }
            j = numRows - 2;
            while(i < n && j >= 0) {
                list.get(j).add(s.charAt(i));
                i++;
                j--;
            }
            j = 1;
        }
        StringBuilder str = new StringBuilder("");
        for(List<Character> temp : list) {
            int size = temp.size();
            for(int x = 0; x < size; x++) {
                str.append(temp.get(x));
            }
        }
        return str.toString();
    }
}