/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class P876_MiddleOfTheLinkedList {

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

    static class Solution {
        public ListNode middleNode(ListNode head) {
            //use fast and slow pointers
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if (fast.next != null) {
                slow = slow.next;
            }
            return slow;
        }
    }
}
