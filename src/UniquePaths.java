public class UniquePaths {
    /**
     * dp思想？
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 从第一行扫
     * time : o(m*n)
     * space : o(n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int dp[] = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n-1];
    }

    /**
     * 排列组合
     *
     * 走到终点需要 n+m-2步；
     * 所以使用排列组合
     * c(N,N-M)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths3(int m, int n) {
        int count = m+n-2;
        int res = 1;
        int k = m-1;
        for (int i = 1; i <= k ; i++) {
            res = res*(count - k + i)/i;
        }
        return res;
    }

}
