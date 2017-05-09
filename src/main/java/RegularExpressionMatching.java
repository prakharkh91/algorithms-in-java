import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by prakhar on 3/4/17.
 */
public class RegularExpressionMatching {
    public enum TypesOfRegex {
        DotStar,
        AlphaStar,
        Alpha,
        Dot
    }

    public static boolean isMatch(String s, String p) {
        Stack<Character> string = new Stack<Character>();
        List<Character> alphaStarChars = new LinkedList<Character>();

        for (int i = s.length() - 1; i >= 0; i--) {
            string.push(s.charAt(i));
        }

        int j;
        TypesOfRegex currentRegex = null;
        for (j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '.' && j+1 < p.length() && p.charAt(j + 1) == '*') {
                currentRegex = TypesOfRegex.DotStar;
                j += 1;
            } else if (p.charAt(j) == '.') {
                currentRegex = TypesOfRegex.Dot;
            } else if (Character.isLetter(p.charAt(j)) && j+1 < p.length() && p.charAt(j + 1) == '*') {
                currentRegex = TypesOfRegex.AlphaStar;
                j += 1;
            } else if (Character.isLetter(p.charAt(j))) {
                currentRegex = TypesOfRegex.Alpha;
            }

            switch (currentRegex) {
                case DotStar:
                    while (true) {
                        if (!string.isEmpty()) {
                            string.pop();
                        } else {
                            break;
                        }
                    }

                case AlphaStar:
                    alphaStarChars.add(p.charAt(j-1));
                    if (j+1 < p.length()) {
                        if (p.charAt(j - 1) != p.charAt(j + 1)) {
                            while (true) {
                                if (!string.isEmpty() && string.peek() == p.charAt(j - 1)) {
                                    string.pop();
                                } else {
                                    break;
                                }
                            }
                        } else {
                            int totalAlpha = 2;
                            j += 1;
                            while (j + 1 < p.length()) {
                                if (p.charAt(j) == p.charAt(j + 1)) {
                                    totalAlpha += 1;
                                    j += 1;
                                } else {
                                    break;
                                }
                            }

                            while (totalAlpha != 0) {
                                if (!string.isEmpty() && string.peek() == p.charAt(j)) {
                                    string.pop();
                                    totalAlpha -= 1;
                                } else {
                                    break;
                                }
                            }

                            if (totalAlpha != 0) {
                                return false;
                            } else {
                                while (true) {
                                    if (!string.isEmpty() && string.peek() == p.charAt(j)) {
                                        string.pop();
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        while (true) {
                            if (!string.isEmpty() && string.peek() == p.charAt(j - 1)) {
                                string.pop();
                            } else {
                                break;
                            }
                        }
                    }
                    break;

                case Alpha:
                    if (!string.isEmpty() && string.peek() == p.charAt(j)) {
                        string.pop();
                    } else {
                        return false;
                    }
                    break;

                case Dot:
                    if (!string.isEmpty()) {
                        string.pop();
                    }
                    break;
            }
        }

        return string.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(RegularExpressionMatching.isMatch("aaa", "a*a"));
    }
}
