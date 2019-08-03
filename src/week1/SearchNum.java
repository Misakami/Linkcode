package week1;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchNum {
    /**
     * 使用两次二分 先找出最小值区间之后判断数组位置 两个logn时间
     */
    public int search(int[] nums, int target) {
        int min = findMin(nums);
        if(min == -1) return min;
        if (nums[nums.length - 1] < target) {
            int num =  mySearch(nums, target, 0, min - 1);
            if (num == -1) return num;
            if (nums[num] != target) return -1;
            return num;
        }else {
            int num =  mySearch(nums, target, min, nums.length -1);
            if (num == -1) return num;
            if (nums[num] != target) return -1;
            return num;
        }
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] <= nums[nums.length - 1]) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    int mySearch(int[] nums, int target, int start, int end) {
        //鲁棒性
        if (nums == null || end < start) return -1;
        int l = start, r = end;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
