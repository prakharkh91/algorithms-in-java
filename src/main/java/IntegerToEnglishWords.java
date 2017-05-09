/**
 * Created by prakhar on 3/5/17.
 */
public class IntegerToEnglishWords {
    private static String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety"};

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        return helper(num).trim();

    }

    private static String helper(int num) {
        StringBuilder sb = new StringBuilder();
        if (num < 10) {
            sb.append(" ").append(belowTen[num]);
        } else if (num < 20) {
            sb.append(" ").append(belowTwenty[num - 10]);
        } else if (num < 100) {
            sb.append(" ").append(belowHundred[num/10]).append(helper(num%10));
        } else if (num < 1000) {
            sb.append(" ").append(belowTen[num/100]).append(" Hundred").append(helper(num % 100));
        } else if (num < 10000) {
            sb.append(helper(num/1000)).append(" Thousand").append(helper(num % 1000));
        } else if (num < 10000000) {
            sb.append(helper(num/1000000)).append(" Million").append(helper(num % 1000000));
        } else {
            sb.append(helper(num/1000000000)).append(" Billion").append(helper(num % 1000000000));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(IntegerToEnglishWords.numberToWords(12345));
    }
}
