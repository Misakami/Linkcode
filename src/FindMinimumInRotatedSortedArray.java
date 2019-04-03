import java.util.regex.Pattern;

public class FindMinimumInRotatedSortedArray {
    /**
     * 升序旋转后使用二分法找到最小值
     * [3,4,5,1,2] 1 2 3 4 5
     * 5 1 2 3 4   4 5 1 2 3
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = nums.length - 1;
        while (start < end - 1) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < nums[end]) {
                end = mid;
            }else {
                start = mid;
            }
        }
        if (nums[start]<nums[end]){
            return nums[start];
        }else
            return nums[end];
    }
}
