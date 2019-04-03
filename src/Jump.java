public class Jump {
    /**
     * 貌似是BFS广度遍历算法思想，每一跳都求出这一跳能跳的最远距离
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int level = 0;
        int maxjump = 0;
        int couldjump = 0;
        int i = 0;
        while (maxjump<nums.length-1){
            level++;
            for (;i<=couldjump;i++){
                maxjump = Math.max(maxjump,i+nums[i]);
                if (maxjump>=nums.length-1)
                    return level;
            }
            couldjump = maxjump;
        }
        return level;
    }
}
