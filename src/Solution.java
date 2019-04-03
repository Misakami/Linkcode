import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     *  数字相加=target
     *  回溯法！确信
     *  递归调用 全排列算法？
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList(),candidates,target,0);
        return res;
    }
    public void helper(List<List<Integer>> res,ArrayList list,int[] candidates, int target,int start){
        if (target < 0){
            return;
        }
        if (target == 0){
            res.add(list);
            return;
        }
        for (int i = start; i < candidates.length-1; i++) {
            list.add(candidates[i]);
            helper(res,list,candidates,target - candidates[i],i);
            list.remove(candidates[i]);
        }
    }
}
