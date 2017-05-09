import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            int sum = 0 - nums[i];
            while (lo < hi) {
                if (nums[lo] + nums[hi] > sum) {
                    hi--;
                } else if (nums[lo] + nums[hi] < sum) {
                    lo--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    break;
                }
            }
        }

        return result.stream().collect(Collectors.toList());
    }
}
