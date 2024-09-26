class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy, temp = dummy;
        for (int i = 1; i <= n + 1; i++) {
            current = current.next;
        }
        while (current != null) {
            current = current.next;
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return dummy.next;
    }
}
