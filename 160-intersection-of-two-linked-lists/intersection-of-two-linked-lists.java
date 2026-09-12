
// public class Solution 
// {
//     public ListNode getIntersectionNode(ListNode head1, ListNode head2)
//      {
//         int len1=0;    // check lenght of ll length 1 
//         ListNode temp1 = head1;
//         while(temp1 !=null){
//             temp1 = temp1.next;
//             len1++;
//         }
//           int len2=0;       // check lenght of ll length 2 
//         ListNode temp2 = head2;
//         while(temp2 !=null){
//             temp2 = temp2.next;
//             len2++;
//         }
//          temp1 = head1;
//            temp2 = head2;
//            if(len1 > len2){
//            for(int i = 0; i<= len1-len2;i++) // temp 1 ko move karenge aage
//            {
//               temp1 = temp1.next;  
//            }
//            }
//            else       // temp 2 ko move karenge aage
//            {
//                   for(int i = 0; i<= len2-len1;i++) 
//            {
//               temp2 = temp2.next;  
//            }
//         }

//         while(temp1 != temp2)
//         {
//              temp1 = temp1.next;  
//               temp2 = temp2.next;  
//         }
//         return temp1 ;
//     }
// }
public class Solution {

    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {

        if (head1 == null || head2 == null) return null;

        int len1 = 0, len2 = 0;

        ListNode temp1 = head1;
        ListNode temp2 = head2;

        // length of list 1
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }

        // length of list 2
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        temp1 = head1;
        temp2 = head2;

        // move longer list ahead
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                temp1 = temp1.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                temp2 = temp2.next;
            }
        }

        // move both together
        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) return temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return null; // no intersection
    }
}
