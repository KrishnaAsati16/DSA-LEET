class Solution {
    public int length (ListNode head){
       // If(head == null) return null;
        int len = 0;
        ListNode temp = head;
           while(temp !=null){
            temp = temp.next;
            len++; 
        }
        return len ;
    }
    public ListNode rotateRight(ListNode head, int k) {
         if(head == null || head.next == null) return head;
        int n = length(head);
        k %= n;
        if(k == 0) return head;
        ListNode slow = head;
         ListNode fast = head;

        for(int i = 0; i<=k ; i++) {
          fast = fast.next ;
          
        }
        while(fast !=null){
            slow = slow.next;
            fast = fast.next;
        }
         ListNode a = slow.next;
         slow.next = null;
          ListNode tail = a;
          while(tail.next != null)
          {
            tail = tail.next;

          }
          tail.next = head;
          return a;
    }
}