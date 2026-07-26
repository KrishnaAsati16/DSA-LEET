class Solution {
    public ListNode sortList(ListNode head) {

        // BASE CASE
        if (head == null || head.next == null) {
            return head;
        }

        // FIND MIDDLE
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // SPLIT
        ListNode head2 = slow.next;
        slow.next = null;

        // RECURSION
        ListNode head1 = sortList(head);
        head2 = sortList(head2);

        // MERGE
        return merge(head1, head2);
    }

    public ListNode merge(ListNode list1, ListNode list2) {

        ListNode i = list1;
        ListNode j = list2;

        ListNode dummy = new ListNode(-1);
        ListNode k = dummy;

        while (i != null && j != null) {
            if (i.val <= j.val) {
                k.next = i;
                i = i.next;
            } else {
                k.next = j;
                j = j.next;
            }
            k = k.next;
        }

        if (i != null) k.next = i;
        else k.next = j;

        return dummy.next;
    }
}
