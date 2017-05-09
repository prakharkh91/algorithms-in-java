import java.util.Stack;

/**
 * Created by prakhar on 3/10/17.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (stack.isEmpty() && (x == ')' || x == ']' || x == '}')) {
                return false;
            } else if (!stack.isEmpty()) {
                if (stack.peek() == '(' && x == ')') {
                    stack.pop();
                } else if (stack.peek() == '[' && x == ']') {
                    stack.pop();
                } else if (stack.peek() == '{' && x == '}') {
                    stack.pop();
                } else {
                    stack.push(x);
                }
            } else {
                stack.push(x);
            }
        }
        return stack.isEmpty();
    }
}
