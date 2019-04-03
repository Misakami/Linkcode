public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1) {
            return true;
        }
        int maxJump = 0;
        int nowJump = 0;
        int i = 0;
        while (maxJump < nums.length - 1) {
            for (; i <= nowJump; i++) {
                maxJump = Math.max(maxJump, i + nums[i]);
            }
            if (nowJump == maxJump) {
                return false;
            }
            nowJump = maxJump;
        }
        return true;
    }
}
