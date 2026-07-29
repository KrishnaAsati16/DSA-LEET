public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         ListNode fast = head;
//         ListNode slow = head;

//         while (fast != null && fast.next != null) {
//             fast = fast.next.next;
//             slow = slow.next;

//             if (fast == slow) {
//                 return true;
//             }
//         }

//         return false;        
//     }
// }