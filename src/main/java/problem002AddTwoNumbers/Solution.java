package problem002AddTwoNumbers;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


/**
 * https://leetcode.com/problems/add-two-numbers/
 */
class Solution {
    /**
     * For Run code
     */
    public static void main(String[] args) {
        // Example 1:
        ListNode inputThree = new ListNode(3);
        ListNode inputTwo = new ListNode(4, inputThree);
        ListNode inputOne = new ListNode(2, inputTwo); // L1 [2,3,4]

        ListNode inputSix = new ListNode(4);
        ListNode inputFive = new ListNode(6, inputSix);
        ListNode inputFour = new ListNode(5, inputFive); // L2 [5,6,4]

        // Run Solution Code
        ListNode nodeResult = Solution.addTwoNumbers(inputOne, inputFour);

        System.out.println("RESULT:" + nodeResult.val);
    }

    /**
     * Solution
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode result = node;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (sum >= 10) {
                node.next = new ListNode(sum - 10);
                carry = 1;
            } else {
                node.next = new ListNode(sum);
                carry = 0;
            }
            node = node.next;
        }

        if (carry == 1) {
            node.next = new ListNode(1);
        }
        return result.next;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


