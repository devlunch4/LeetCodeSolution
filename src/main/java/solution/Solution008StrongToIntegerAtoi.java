package solution;

public class Solution008StrongToIntegerAtoi {
    public static class Solution {
        public static int myAtoi(String s) {
            if (s.isEmpty()) {
                return 0;
            }

            // Step 1. Replace WhiteSpace
            s = s.replaceAll("^\\s+", ""); // replace Start[^] and Whitespace[\s]

            // Step 2. Check "+", "-"
            int i = 0; // Counter
            int sign = 1;
            if (s.startsWith("-") || s.startsWith("+")) {
                sign = (s.charAt(i) == '-') ? -1 : 1;
                i++;
            }

            // Step 3, 4. Set Number
            int number = 0;
            for (; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
                // Step 5. Check and Set Number value, Max and Min
                if (number > Integer.MAX_VALUE / 10 ||
                        (number == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                number = number * 10 + (s.charAt(i) - '0');
            }

            // int prime 1410065407
            return sign * number;
        }
    }

    public static void main(String[] args) {
        long startTimeFirst = System.currentTimeMillis();
        System.out.println("Example 1:\nInput: s = \"42\"\nOutput: 42");
        String s = "42";
        System.out.println("result: " + Solution.myAtoi(s));
        long endTimeFirst = System.currentTimeMillis();
        System.out.printf(">>> code Run Time: [%d]ms%n", endTimeFirst - startTimeFirst);

        long startTimeSecond = System.currentTimeMillis();
        System.out.println("\nExample 2:\nInput: s = \"   -42\"\nOutput: -42");
        s = "   -42";
        System.out.println("result: " + Solution.myAtoi(s));
        long endTimeSecond = System.currentTimeMillis();
        System.out.printf(">>> code Run Time: [%d]ms%n", endTimeSecond - startTimeSecond);

        long startTimeThird = System.currentTimeMillis();
        System.out.println("\nExample 3:\nInput: s = \"4193 with words\"\nOutput: 4193");
        s = "4193 with words";
        System.out.println("result: " + Solution.myAtoi(s));
        long endTimeThird = System.currentTimeMillis();
        System.out.printf(">>> code Run Time: [%d]ms%n", startTimeThird - endTimeThird);
    }
}

// Description
/*
8. String to Integer (atoi)

 Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 <p>
 The algorithm for myAtoi(string s) is as follows:
 <p>
 Read in and ignore any leading whitespace.
 Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 Return the integer as the final result.
 Note:
 <p>
 Only the space character ' ' is considered a whitespace character.
 Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 <p>
 <p>
 Example 1:
 <p>
 Input: s = "42"
 Output: 42
 Explanation: The underlined characters are what is read in, the caret is the current reader position.
 Step 1: "42" (no characters read because there is no leading whitespace)
 ^
 Step 2: "42" (no characters read because there is neither a '-' nor '+')
 ^
 Step 3: "42" ("42" is read in)
 ^
 The parsed integer is 42.
 Since 42 is in the range [-231, 231 - 1], the final result is 42.
 Example 2:
 <p>
 Input: s = "   -42"
 Output: -42
 Explanation:
 Step 1: "   -42" (leading whitespace is read and ignored)
 ^
 Step 2: "   -42" ('-' is read, so the result should be negative)
 ^
 Step 3: "   -42" ("42" is read in)
 ^
 The parsed integer is -42.
 Since -42 is in the range [-2^31, 2^31 - 1], the final result is -42.
 Example 3:
 <p>
 Input: s = "4193 with words"
 Output: 4193
 Explanation:
 Step 1: "4193 with words" (no characters read because there is no leading whitespace)
 ^
 Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
 ^
 Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
 ^
 The parsed integer is 4193.
 Since 4193 is in the range [-2^31, 2^31 - 1], the final result is 4193.
 <p>
 <p>
 Constraints:
 <p>
 0 <= s.length <= 200
 s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 */