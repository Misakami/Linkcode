public class UniquePaths2 {
    /**
     *
     * dp，中间有障碍时设置0
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[] = new int[obstacleGrid[0].length];
        dp[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                }else if(j > 0)
                    dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }
}
