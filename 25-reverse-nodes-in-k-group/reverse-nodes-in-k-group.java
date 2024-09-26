class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode temp = dummy;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }

        temp = dummy;
        while (count >= k) {
            int nodes = k;
            ListNode tempNext = temp.next;
            ListNode first = temp.next;
            ListNode second = first.next;

            while (nodes-- > 1) {
                ListNode next = second.next;
                second.next = first;
                first = second;
                second = next;
            }

            temp.next = first;
            tempNext.next = second;
            temp = tempNext;
            count -= k;
        }

        return dummy.next;
    }
}
