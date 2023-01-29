package solution;

/**
 * <a href="https://leetcode.com/problems/zigzag-conversion/">6. Zigzag Conversion</a>
 */
public class Solution006ZigzagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder answer = new StringBuilder();//new StringBuilder();
        String[] str = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            str[i] = "";
        }
        int mod = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = i % mod;
            if (idx >= numRows) idx = 2 * (numRows - 1) - idx;
            str[idx] += c;
        }
        for (int i = 0; i < numRows; i++) {
            answer.append(str[i]);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(convert("PAYPALISHIRING", 3));
        long endTime = System.currentTimeMillis();
        System.out.printf(">>> code Run Time: [%d]ms%n", endTime - startTime); //FOR CHECK RUNNING TIME
    }
}