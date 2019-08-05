package week2;

public class SortList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * <p>
     * 空间要求常数级 所以归并排序需要自底向上的归并排序 循环
     */
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int n = 0;
        for (ListNode p = head; p != null; p = p.next) {
            n++;
        }

        //划分空间 1-2-4-8
        for (int i = 1; i < n; i *= 2) {
            ListNode cur = dummy;

            //进行每两块之间的排序
            for (int j = 0; j + i < n; j += i * 2) {
                ListNode left = cur.next, right = cur.next;
                for (int k = 0; k < i; k++) {
                    right = right.next;
                }
                int l = 0, r = 0;
                while (l < i && r < i && right != null) {
                    if (left.val <= right.val ) {
                        cur.next = left;
                        cur = left;
                        left = left.next;
                        l++;
                    }else {
                        cur.next = right;
                        cur = right;
                        right = right.next;
                        r++;
                    }
                }
                while (l<i){
                    cur.next = left;
                    cur = left;
                    left = left.next;
                    l++;
                }
                while (r<i&&right!=null){
                    cur.next = right;
                    cur = right;
                    right = right.next;
                    r++;
                }
                cur.next = right;
            }
        }
        return dummy.next;
    }
}
