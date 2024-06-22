class Solution {
    public static void reverse(char[] arr, int start, int end) {
        while(start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder();
        char[] arr = s.toCharArray();
        int i = 0;
        while(i < n) {
            if(arr[i]== ' ') {
                i++;
            }
            else{
                break;
            }
        }
        for(int j = i; j < n; j++) {
            if(arr[j] == ' ' && arr[i] != ' ') {
                reverse(arr, i, j-1);
                i = j;
            }
            else if(arr[i] == ' ') {
                i++;
            }
        }
        reverse(arr, i, n - 1);
        int space = 0;
        reverse(arr, 0, n - 1);
        for(int j = 0; j < n; j++) {
            if(arr[j] != ' ') {
                space = 0;
                str.append(arr[j]);
            }
            else {
                if(space==0){
                    str.append(arr[j]);
                    space = 1;
                }
            }
        }
        return str.toString().trim();
    }
}