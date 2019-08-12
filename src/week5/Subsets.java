package week5;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 */
public class Subsets {
    //回溯法

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void helper(int[] nums, int i, ArrayList<Integer> path) {
        List<Integer> nowpath = new ArrayList<>(path);
        res.add(nowpath);
        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            helper(nums, j + 1, path);
            path.remove(path.indexOf(nums[j]));
        }
    }
}
