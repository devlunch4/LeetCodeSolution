package solutionJunit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

import static problem001TwoSum.Solution.twoSum;

class SolutionTest001 {

    @Test
    public void test01() {
        // Example 1:
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ourput = {0, 1};
        String answer = Arrays.toString(twoSum(nums, target));
        String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println(methodName + " answer Value:" + answer);
        assertEquals(Arrays.toString(ourput), answer);
    }

    @Test
    public void test02() {
        // Example 2:
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] ourput = {1, 2};
        String answer = Arrays.toString(twoSum(nums, target));
        String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println(methodName + " answer Value:" + answer);
        assertEquals(Arrays.toString(ourput), answer);
    }

    @Test
    public void test03() {
        // Example 2:
        int[] nums = {3, 3};
        int target = 6;
        int[] ourput = {0, 1};
        String answer = Arrays.toString(twoSum(nums, target));
        String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println(methodName + " answer Value:" + answer);
        assertEquals(Arrays.toString(ourput), answer);
    }
}