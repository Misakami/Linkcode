public class MinPathSum {

    /**
     * dp 最短路径
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int length = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == 0 && j > 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0 && i != 0) {
                    grid[i][j] += grid[i - 1][j];
                } else if (j != 0) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[grid.length - 1][length - 1];
    }
}
