import java.util.*;

/**
 * Created by prakhar on 3/3/17.
 */
public class NextGreaterElement {
    public int[] nextGreaterElementCorrected(int[] findNums, int[] nums) {
        int[] res = new int[findNums.length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();

        for (int num: nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.getOrDefault(findNums[i], -1);
        }

        return res;
    }

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] res = new int[findNums.length];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums.length) {
                if (nums[i] < nums[i + 1]) {
                    map.put(nums[i], nums[i + 1]);
                }
            }
        }

        for (int i = 0; i < findNums.length; i++) {
            if (map.containsKey(findNums[i])) {
                res[i] = map.get(findNums[i]);
            } else {
                res[i] = -1;
            }
        }

        return res;
    }
}
