package solution;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/">2. Add Two Numbers Solution And TestCode(main)</a>
 */
public class Solution002AddTwoNumbers {
    /**
     * For Run code
     */
    public static void main(String[] args) {
        // Example 1:
        // Input: l1 = [2,4,3], l2 = [5,6,4]
        // Output: [7,0,8]
        // Explanation: 342 + 465 = 807.
        ListNode inputThree = new ListNode(3);
        ListNode inputTwo = new ListNode(4, inputThree);
        ListNode inputOne = new ListNode(2, inputTwo); // L1 [2,3,4]

        ListNode inputSix = new ListNode(4);
        ListNode inputFive = new ListNode(6, inputSix);
        ListNode inputFour = new ListNode(5, inputFive); // L2 [5,6,4]


        // Run Solution Code, Result.
        ListNode nodeResult = addTwoNumbers(inputOne, inputFour);
        int count = 0;
        while (nodeResult != null) {
            System.out.println("Result Node Index: [" + count + "]-> Value: " + nodeResult.val);
            nodeResult = nodeResult.next;
            count++;
        }

        System.out.println("***Official Guide Code Run Result");
        System.out.println(addTwoNumbersGuide(inputOne, inputFour));
    }


    /**
     * Solution002
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

    /**
     * Official Guide Code - Solution002
     *
     * @param l1 input l1
     * @param l2 input l2
     * @return res
     */
    public static ListNode addTwoNumbersGuide(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

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
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}



