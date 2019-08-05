package week2;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntersectionNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 两个链表的交点 剑指OFEER题但是没印象了 ：用的栈 或者求出长度
     *
     * 无敌思路 走的路程永远是 a+b 有交点时走到交点处 没交点时走完两条线 都为null
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p = headA;
            ListNode q = headB;
            while(p!=q){
                if(p!=null) p = p.next;
                else p = headB;
                if(q!=null) q = q.next;
                else q = headA;
            }
            return q;
        }
}
