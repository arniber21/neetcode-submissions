class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for(char c: s.toCharArray()) {
            if(c == '{') {
                stack.push(c);
            }
            else if(c == '[') {
                stack.push(c);
            }
            else if(c == '(') {
                stack.push(c);
            }
            else if(c == '}') {
                if(stack.peek() == null || stack.peek() != '{') return false;
                stack.pop();
            }
            else if(c == ']') {
                if(stack.peek() == null || stack.peek() != '[') return false;
                stack.pop();
            }
            else if(c == ')') {
                if(stack.peek() == null || stack.peek() != '(') return false;
                stack.pop();
            }
        }

        return stack.size() == 0;
    }
}
