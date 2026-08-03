class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        ArrayList<ListNode> arr = new ArrayList<>();

        for (ListNode n : lists) {
            if (n != null) arr.add(n);
        }

        // 🔴 FIX FOR RUNTIME ERROR
        if (arr.size() == 0) return null;

        while (arr.size() > 1) {
            ListNode a = arr.remove(arr.size() - 1);
            ListNode b = arr.remove(arr.size() - 1);

            ListNode c = mergeTwoLists(a, b);
            arr.add(c);
        }

        return arr.get(0);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode k = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                k.next = list1;
                list1 = list1.next;
            } else {
                k.next = list2;
                list2 = list2.next;
            }
            k = k.next;
        }

        k.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}
