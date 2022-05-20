package problem001TwoSum;

import java.util.Arrays;

/***
 * https://leetcode.com/problems/two-sum/
 */
public class Solution {
    public static void main(String[] args) {
        // Example 1:
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;

        // Example 2:
//        int[] nums = {3, 2, 4};
//        int target = 6;

        // Example 3:
        int[] nums = {3, 3};
        int target = 6;


        int[] resNum = twoSum(nums, target);
        Arrays.stream(resNum).forEach(System.out::println);
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
