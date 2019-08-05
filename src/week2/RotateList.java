package week2;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 旋转链表 首先找到成为头节点的地方 然后因为链表长度为一定值
     * 所以可以通过模来找到节点自身所在的位置
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
