package week1;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindPeakElement {
    //寻找峰值问题，理解线性的折点关系一定是递增的 如果为递减则第一个绝对为峰值 如果为递增则最后一个绝对为峰值
    public int findPeakElement(int[] nums) {
        int l = 0,r = nums.length-1;
        while (l < r){
            int mid = r + l >> 1;
            if (nums[mid] > nums[mid+1]) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
