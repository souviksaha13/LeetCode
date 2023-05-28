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
        ListNode head = new ListNode(l1.val + l2.val);
        ListNode curr = head;
        int carry = 0;
        if(l1.val + l2.val >= 10) carry = 1;
        head.val = (head.val)%10;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null && l2 != null) {
            if(carry == 1){
                ListNode temp = new ListNode(l1.val + l2.val + 1);
                curr.next = temp;
                curr = curr.next;
                if(curr.val <= 9) carry--;
                l1 = l1.next;
                l2 = l2.next;
            } else {
                ListNode temp = new ListNode(l1.val + l2.val);
                curr.next = temp;
                curr = curr.next;
                if(curr.val >= 10) carry++;
                l1 = l1.next;
                l2 = l2.next;
            }
            curr.val = (curr.val)%10;
        }
        
        while(l1 != null) {
            if(carry == 1) {
                ListNode temp = new ListNode(l1.val + 1);
                curr.next = temp;
                curr = curr.next;
                l1 = l1.next;
                if(curr.val <= 9) carry --;
            } else {
                ListNode temp = new ListNode(l1.val);
                curr.next = temp;
                curr = curr.next;
                l1 = l1.next;
                if(curr.val >= 10) carry++;
            }
            curr.val = (curr.val)%10;
        }
        
        while(l2 != null) {
            if(carry == 1) {
                ListNode temp = new ListNode(l2.val + 1);
                curr.next = temp;
                curr = curr.next;
                l2 = l2.next;
                if(curr.val <= 9) carry --;
            } else {
                ListNode temp = new ListNode(l2.val);
                curr.next = temp;
                curr = curr.next;
                l2 = l2.next;
                if(curr.val >= 10) carry++;
            }
            curr.val = (curr.val)%10;
        }
        
        if(carry == 1) {
            ListNode temp = new ListNode(1);
            curr.next = temp;
        }
        return head;
    }
}