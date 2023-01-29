package solution;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">3. Longest Substring Without Repeating Characters</a>
 */
public class Solution003LongestSubstringWithoutRepeatingCharacters {

    /**
     * Run Solution Code
     *
     * @param args none
     */
    public static void main(String[] args) {
        // Example1
        // Input: s = "abcabcbb"
        // Output: 3
        // Explanation: The answer is "abc", with the length of 3.
        String str1 = "abcabcbb";
        System.out.println(str1 + ": " + lengthOfLongestSubstring(str1));


        // Example2
        // Input: s = "bbbbb"
        // Output: 1
        // Explanation: The answer is "b", with the length of 1.
        String str2 = "bbbbb";
        System.out.println(str2 + ": " + lengthOfLongestSubstring(str2));

        // Example3
        // Input: s = "pwwkew"
        // Output: 3
        // Explanation: The answer is "wke", with the length of 3.
        // Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
        String str3 = "pwwkew";
        System.out.println(str3 + ": " + lengthOfLongestSubstring(str3));

        // for learn, test.
        setTransListSort();
    }


    /**
     * Solution003
     *
     * @param s input String
     * @return Given a string s, find the length of the longest substring without repeating characters.
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Object> set = new HashSet<>();
        int strLength = s.length();
        int begin = 0;
        int end = 0;
        int res = 0;
        int count = 0;
        int flag = 0;
        while (end < strLength) {
            //abcabcbb
            count++;
            char x = s.charAt(end);
            //System.out.println("s.charAt(end): "+ s.charAt(end));
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(begin++));
                //   flag = 0;
            } else {
                set.add(s.charAt(end++));
                res = Math.max(res, end - begin);
                //    flag = 1;
            }
            System.out.printf("%d: begin:[%d] end:[%d] set:%s >> res: %d s.charAt(end):%s flag:%d%n", count, begin, end, set, res, x, flag);
        }
        System.out.println();
        return res;
    }

    /**
     * Test and Check the order of entry.
     */
    public static void setTransListSort() {
        System.out.println("* Test and Check the order of entry.");
        Set<String> fruits = new HashSet<>();

        fruits.add("banana");
        fruits.add("apple");
        fruits.add("peach");
        System.out.println("fruits: " + fruits);

        // Converting Object Set to List
        List<String> fruitList = new ArrayList<>(fruits);
        // List Sort
        Collections.sort(fruitList);
        System.out.println("fruitList: " + fruitList);
        // Print, Java For Each Loop
        for (String str : fruitList) {
            System.out.println(str);
        }
        // Another Print, Lambda
        fruitList.forEach(System.out::println);
        // "apple", "baana", "peach"
    }
}