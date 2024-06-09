class Solution {
    public int numberOfChild(int n, int k) {
        int i = 0;
        boolean flag = true;
        for(int j = 0; j < k; j++) {
            if(flag) {
                i++;
            }
            else {
                i--;
            }
            if(i == n-1) {
                flag = false;
            }
            if(i == 0) {
                flag = true;
            }
        }
        return i;
    }
}