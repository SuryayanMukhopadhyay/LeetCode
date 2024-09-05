class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = stack.peek();
                stack.pop();
                int b = stack.peek();
                stack.pop();
                if(token.equals("+")) {
                    stack.push(a + b);
                }
                else if(token.equals("-")) {
                    stack.push(b - a);
                }
                else if(token.equals("*")) {
                    stack.push(a * b);
                }
                else {
                    if(a == 0 || b == 0) {
                        stack.push(0);
                    }
                    else {
                        stack.push(b / a);
                    }
                }
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}