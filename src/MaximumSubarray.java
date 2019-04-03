public class MaximumSubarray {
    /**
     * 返回最大子串和
     * dp思想 贪心求当前最大值
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i-1]<0?0:dp[i-1]);
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
