public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preLeft = dummy;
        for (int i = 1; i < left; i++) {
            preLeft = preLeft.next;
        }

        ListNode current = preLeft.next;
        ListNode prev = null;
        for (int i = left; i <= right; i++) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        preLeft.next.next = current;
        preLeft.next = prev;

        return dummy.next;
    }
}
