package problem004_median_of_two_sorted_arrays;

import java.util.Arrays;

/**
 * 4. Median of Two Sorted Arrays
 * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">4. Median of Two Sorted Arrays</a>
 */
class Solution {
    //public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] newNums = new int[m + n];

        int i = 0; // nums1 index
        int j = 0; // nums2 index
        int k = 0; // newNums index

        for (i = 0; i < m + n; i++) {
            // set nweNums
            if (j == m) {
                newNums[i] = nums2[k];
                k++;
            } else if (k == n) {
                newNums[i] = nums1[j];
                j++;
            } else if (nums1[j] > nums2[k]) {
                newNums[i] = nums2[k];
                k++;
            } else if (nums1[j] <= nums2[k]) {
                newNums[i] = nums1[j];
                j++;
            }
        }
        // return >> Set Result Value
        if ((m + n) % 2 != 0) {
            return (newNums[(m + n) / 2]);
        } else {
            return ((double) (newNums[((m + n) / 2) - 1] + newNums[(m + n) / 2]) / 2);
        }
    }

    // Test
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("nums1 Array: " + Arrays.toString(nums1));
        System.out.println("nums2 Array: " + Arrays.toString(nums2));
        System.out.println(">>> result: " + findMedianSortedArrays(nums1, nums2));
    }
}