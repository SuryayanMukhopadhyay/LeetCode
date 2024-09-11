class Solution {
    public int minBitFlips(int start, int goal) {
        int x = start, y = goal;
        StringBuilder str1 = new StringBuilder("");
        while(x > 0) {
            if(x % 2 == 0) {
                str1.append('0');
            }
            else {
                str1.append('1');
            }
            x /= 2;
        }
        StringBuilder str2 = new StringBuilder("");
        while(y > 0) {
            if(y % 2 == 0) {
                str2.append('0');
            }
            else {
                str2.append('1');
            }
            y /= 2;
        }
        int flips = 0;
        int m = str1.length(), n = str2.length();
        int i = 0;
        while(i < m && i < n) {
            if(str1.charAt(i) != str2.charAt(i)) {
                flips++;
            }
            i++;
        }
        while(i < m) {
            if(str1.charAt(i) == '1') {
                flips++;
            }
            i++;
        }
        while(i < n) {
            if(str2.charAt(i) == '1') {
                flips++;
            }
            i++;
        }
        return flips;
    }
}