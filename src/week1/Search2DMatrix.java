package week1;

public class Search2DMatrix {
    /**
     * 排序矩阵值
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix ==  null || matrix.length == 0 || matrix[0].length == 0) return false;

        int n = matrix.length, m = matrix[0].length;
        int l = 0, r = n * m - 1;

        while (l < r) {
            int mid = r + l >> 1;
            if (matrix[mid / m][mid % m] >= target) r = mid;
            else l = mid + 1;
        }
        if (matrix[l / m][l % m] != target) return false;
        return true;
    }
}
