package week1;

public class SearchInsert {
    /**
     * 排序数组找目标
     */
    int mySearch(int[] nums, int target) {
        //鲁棒性
        if (nums == null) return 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
