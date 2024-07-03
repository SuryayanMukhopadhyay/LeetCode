class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n <= 1) return false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else if(ch == ')') {
                if(stack.isEmpty()) return false;
                if(stack.peek() == '(') {
                    stack.pop();
                }
                else return false;
            }
            else if(ch == '}') {
                if(stack.isEmpty()) return false;
                if(stack.peek() == '{') {
                    stack.pop();
                }
                else return false;
            }
            else {
                if(stack.isEmpty()) return false;
                if(stack.peek() == '[') {
                    stack.pop();
                }
                else return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}