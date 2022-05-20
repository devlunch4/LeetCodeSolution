package problem001TwoSum;

import java.util.Arrays;
import java.util.HashMap;

/***
 * https://leetcode.com/problems/two-sum/
 */
public class SolutionHashMap {
    public static void main(String[] args) {
        // Example 1:
        int[] nums = {1, 7, 11, 15, 8};
        int target = 9;

        // Example 2:
//        int[] nums = {3, 2, 4};
//        int target = 6;

        // Example 3:
//        int[] nums = {3, 3};
//        int target = 6;

        long start = System.nanoTime();
        int[] resNum = twoSum(nums, target);
        Arrays.stream(resNum).forEach(System.out::println);
        long end = System.nanoTime();
        System.out.println("Running time: " + (end - start) + " ns");
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int numsLength = nums.length;
        Integer res; // https://includestdio.tistory.com/1
        for (int i = 0; i < numsLength; i++) {
            res = map.get(nums[i]);
            if (res != null) {
                return new int[]{res, i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[]{1, 2};
    }
}

