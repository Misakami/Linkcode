package week5;

import java.util.ArrayList;
import java.util.List;

public class PermutationsⅡ {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums);
        return res;
    }

    public void helper(List<List<Integer>> res, ArrayList list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(res, list, nums);
            list.remove(list.size() - 1);
        }
    }

    public void helper2(List<List<Integer>> res, int start, int[] nums) {
        if (start == nums.length) {
            ArrayList list = new ArrayList();
            for (int num : nums
                    ) {
                list.add(num);
            }
            res.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums,start,i);
            helper2(res,start+1,nums);
            swap(nums,start,i);
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
