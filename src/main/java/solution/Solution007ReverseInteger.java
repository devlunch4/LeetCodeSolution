package solution;

public class Solution007ReverseInteger {
    public static class Solution {
        static int reverse(int x) {
            boolean isNegative = false;
            if (x < 0) {
                isNegative = true;
                x = -x;
            }
            long reverse = 0;
            while (x > 0) {
                reverse = reverse * 10 + x % 10;
                x /= 10;
            }
            if (reverse > Integer.MAX_VALUE) {
                return 0;
            }
            return (int) (isNegative ? -reverse : reverse);
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Insert: -123");
        System.out.println("Output: "+ Solution.reverse(-123));
        long endTime = System.currentTimeMillis();
        System.out.printf(">>> code Run Time: [%d]ms%n", endTime - startTime); //FOR CHECK RUNNING TIME

        long startTimeTwo = System.currentTimeMillis();
        System.out.println("Insert: 123");
        System.out.println("Output: "+ Solution.reverse(123));
        long endTimeTwo = System.currentTimeMillis();
        System.out.printf(">>> code Run Time: [%d]ms%n", endTimeTwo - startTimeTwo); //FOR CHECK RUNNING TIME
    }
}
