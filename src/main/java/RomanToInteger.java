import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by prakhar on 3/5/17.
 */
public class RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int res = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res + map.get(s.charAt(s.length() - 1));
    }

    public static String intToRoman(int num) {
        Map<Integer, String> map = new LinkedHashMap<Integer, String>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry: map.entrySet()) {
            while (num >= (Integer) entry.getKey() ) {
                num -= (Integer) entry.getKey();
                sb.append(entry.getValue());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int res = RomanToInteger.romanToInt("MCMXCVI");
        System.out.println(res);
    }
}
