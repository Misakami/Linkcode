public class SortList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 时间复杂度限制n*logn 所以使用分治法
     * 归并排序
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null)
            return head;
        ListNode fast = head, low = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = low;
            low = low.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(low);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);
        ListNode cur = new ListNode(0);
        dummy.next = cur;
        while (l != null && r != null) {
            if (l.val < r.val) {
                cur = l;
                l = l.next;
            } else {
                cur = r;
                r = r.next;
            }
            cur = cur.next;
        }
        if (l != null) {
            cur = l;
        }
        if (r != null) {
            cur = r;
        }
        return dummy;
    }

}
