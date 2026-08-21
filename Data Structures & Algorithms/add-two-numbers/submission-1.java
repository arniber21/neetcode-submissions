/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if(l1 == null && l2 == null && carry == 0) return null;
        int left = l1 != null ? l1.val : 0;
        ListNode leftNext = l1 != null ? l1.next : l1;
        int right = l2 != null ? l2.val : 0;
        ListNode rightNext = l2 != null ? l2.next : l2;
        int sum = left + right + carry;
        carry = 0;
        if(sum >= 10) {
            sum -= 10;
            carry = 1;
        }
        return new ListNode(sum, addTwoNumbers(leftNext, rightNext, carry));
    }
}
