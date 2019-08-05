package week2;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 */
public class RemoveDuplicates {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 删除重复节点  因为是排好序的 所以双指针或者直接循环删除
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode cur = head;
            while (cur!=null){
                while (cur.next!=null&&cur.val == cur.next.val) cur.next = cur.next.next;
                cur = cur.next;
            }
            return head;
        }
    }
}
