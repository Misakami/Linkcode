public class RotateList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        ListNode res = head;
        int length = 1;
        while (res.next != null) {
            res = res.next;
            length++;
        }
        res.next = head;
        for (int i = 1; i < length - k % length; i++) {
            head = head.next;
        }
        res = head.next;
        head.next = null;
        return res;
    }
}
