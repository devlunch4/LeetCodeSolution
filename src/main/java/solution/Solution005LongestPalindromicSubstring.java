package solution;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">5. Longest Palindromic Substring</a>
 */
public class Solution005LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
//        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
//            System.out.println(cnt++);
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * Left, Right Character Value Compare And Check index.
     *
     * @param s input String
     * @param left input left int
     * @param right input right int
     * @return result(right-left-1)
     */
    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//            System.out.println("s.charAt(L): "+s.charAt(L));
//            System.out.println("s.charAt(R): "+s.charAt(R));
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}