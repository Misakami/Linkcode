package week5;

/**
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 * <p>
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,2,2,2]
 * 输出: true
 * <p>
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matchsticks-to-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;
import java.util.List;


/**
 * 剪枝教科书
 */
public class MatchsiticksToSquare {
    boolean st[];

    public boolean makesquare(int[] nums) {
        int sum = 0;
        st = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(nums);
        nums = reverse(nums);
        return dfs(nums, 0, 0, sum / 4);
    }

    private boolean dfs(int[] nums, int u, int cur, int length) {
        if (cur == length) {
            cur = 0;
            u++;
        }
        if (u == 4) return true;
        for (int i = 0; i < nums.length; i++) {
            if (!st[i] && cur + nums[i] <= length) {
                st[i] = true;
                if (dfs(nums, u, cur + nums[i], length)) return true;
                st[i] = false;
                if (cur == 0) return false;
                if (cur + nums[i] == length) return false;
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
            }
        }
        return false;
    }

    public static int[] reverse(int[] arr) {
        //遍历数组
        for (int i = 0; i < arr.length / 2; i++) {
            //交换元素 因为i从0开始所以这里一定要再减去1
            int temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = temp;
        }
        //返回反转后的结果
        return arr;
    }
}
