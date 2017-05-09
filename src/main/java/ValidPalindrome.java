import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by prakhar on 3/11/17.
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        LinkedList<Character> queue = new LinkedList<>();

        if (s.length() == 0) {
            return true;
        }

        for (int i = s.length() - 1; i >=0 ; i--) {
            char x = s.charAt(i);
            if (Character.isLetter(x)) {
                x = Character.toLowerCase(x);
            }

            if (Character.isLetter(x) || Character.isDigit(x)) {
                stack.push(x);
                queue.offerFirst(x);
            }
        }

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            if (stack.peek() == queue.peekLast()) {
                stack.pop();
                queue.removeLast();
            }
        }

        return (stack.size() == 0 && queue.size() == 0);
    }

    public static void main(String[] args) {
        ValidPalindrome.isPalindrome("aa");
    }
}
