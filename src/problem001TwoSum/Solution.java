package problem001TwoSum;

import java.util.Arrays;

/***
 * <a href="https://leetcode.com/problems/two-sum/">1. Two Sum</a>
 */
public class Solution {
    public static void main(String[] args) {
        // Example 1:
        int[] nums = {2, 7, 11, 15};
        int target = 9;

//         Example 2:
//        int[] nums = {3, 2, 4};
//        int target = 6;

//         Example 3:
//        int[] nums = {3, 3};
//        int target = 6;

        long start = System.nanoTime();
        int[] resNum = twoSum(nums, target);
        System.out.println("resNum: "+Arrays.toString(resNum));
        Arrays.stream(resNum).forEach(System.out::println);
        long end = System.nanoTime();
        System.out.println("Running time: " + (end - start) + " ns");
    }

    public static int[] twoSum(int[] nums, int target) {
        int numsLength = nums.length;
        for (int i = 0; i < numsLength - 1; ++i) {
            for (int j = i + 1; j < numsLength; ++j) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
}
