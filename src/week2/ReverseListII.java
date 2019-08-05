package week2;

public class ReverseListII {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode start = dummy;
            while (m > 1) {
                start = start.next;
                m--;
                n--;
            }
            ListNode a = start;
            ListNode b = start.next;
            while (n - m >= 0){
                ListNode c;
                c = b.next;
                b.next = a;
                a = b;
                b = c;
                n--;
            }
            start.next.next = b;
            start.next = a;
            return dummy.next;
        }
    }
}
