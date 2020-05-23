/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode curr = head;
        ListNode even = head.next;
        ListNode prev = head;
        ListNode future = head.next;
        while (curr != null && curr.next != null) {
            future = curr.next;
            curr.next = future.next;
            if (curr.next != null)
                future.next = curr.next.next;
            prev = curr;
            curr = curr.next;
        }
        // System.out.println(prev.val);
        if (curr != null)
            curr.next = even;
        else
            prev.next = even;
        // printList(head);
        return head;
    }

    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            curr = curr.next;
        }
    }
}