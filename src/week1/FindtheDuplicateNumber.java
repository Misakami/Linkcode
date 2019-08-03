package week1;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindtheDuplicateNumber {
    /**
     * 数组内的数字都来源于 1到N之间 通过对半分可以统计出 目标区域一半的数字总数
     * 如果数字总数并没有达到该有的一半时，那么重复的数字肯定就在另一半内
     */

    public int findDuplicate(int[] nums) {
        if (nums == null) return -1;
        int l = 1, r = nums.length -1;
        while (l < r) {
            int mid = l + r >> 1;
            int cou = 0;
            for (int i : nums
                    ) {
                if (i <= mid && i >= l) cou++;
            }
            System.out.println(cou);
            if (cou > mid - l + 1) r = mid;
            else l = mid + 1;

        }
        return r;
    }
}
