import java.util.Arrays;

public class RotateImage {
        public void rotate(int[][] matrix) {
            for (int i = 0; i < matrix.length - 1; i++) {
                for (int j = i; j < matrix[0].length - i - 1; j++) {
                    int tmp = matrix[matrix.length - j - 1][i];
                    matrix[matrix.length - j - 1][i] = matrix[matrix.length - i - 1][matrix.length - j - 1];
                    matrix[matrix.length - i - 1][matrix.length - j - 1] = matrix[j][matrix.length - i - 1];
                    matrix[j][matrix.length - i - 1] = matrix[i][j];
                    matrix[i][j] = tmp;
                }
            }
        }
}
