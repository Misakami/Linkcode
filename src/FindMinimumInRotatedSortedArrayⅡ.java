public class FindMinimumInRotatedSortedArrayⅡ {
    /**
     * 可重复的旋转数组
     * 如何去重？
     * 3313
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
            if (nums[mid] == nums[end] && mid < end) {
                end--;
                continue;
            }
            if (nums[mid] == nums[start] && start < mid) {
                start++;
                continue;
            }
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return nums[start];
        } else
            return nums[end];
    }
}
