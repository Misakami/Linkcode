package week5;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum3 {
        int k, n;
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            this.k = k;
            this.n = n;
            helper(1,0, new ArrayList<Integer>());
            return res;
        }

        private void helper(int i,int sum, ArrayList<Integer> path) {
            if (path.size() == k) {
                if (sum == n) res.add(new ArrayList<>(path));
            }
            for (; i < 10; i++) {
                sum += i;
                path.add(i);
                helper(i+1,sum, path);
                sum -= i;
                path.remove(path.size() - 1);
            }
        }
}
