package week1;

public class FindFirstanLastPositionofElementinSortedArray {
    /**
     *一堆数第一次出现以及最后一次出现
     *
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int l = 0, r = nums.length -1;
        int mid = 0;
        while (l < r) {
            mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if (nums[l] != target) return new int[]{-1, -1};
        int start = l;
        l = start;
        r = nums.length - 1;
        while (l < r) {
            mid = l + r + 1>> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        return new int[]{start, l};
    }
}
