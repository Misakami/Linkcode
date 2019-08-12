package week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubsetsII {
    //回溯法去重的基本套路 判断是否相同 是就跳过
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); //排序
        getAns(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            //和上个数字相等就跳过
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            getAns(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

}
