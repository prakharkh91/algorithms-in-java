import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by prakhar on 3/10/17.
 */
public class LetterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<>();
        String[] pad = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits.length()==0){
            return list;
        }
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (list.peek().length() == i) {
                String t = list.remove();
                for (Character c: pad[x].toCharArray()) {
                    list.add(t + c);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = LetterCombinationsOfAPhoneNumber.letterCombinations("2");
    }
}
