package week5;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 十字链表可以解决大部分的精确覆盖问题
 * <p>
 * 常规深搜 一个一个判断
 */
public class SolveSudoku {
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][][] sodu = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int t = board[i][j] - '0';
                    row[i][t] = col[j][t] = sodu[i / 3][j / 3][t] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int x, int y) {
        if (y == 9) {
            x++;
            y = 0;
        }
        if (x == 9) return true;
        if (board[x][y] != '.') return dfs(board, x, y + 1);
        for (int i = 0; i < 9; i++) {
            if (!row[x][i] && !col[y][i] && !sodu[x / 3][y / 3][i]) {
                board[x][y] = (char) ('1'+i);
                row[x][i] = col[y][i] = sodu[x / 3][y / 3][i] = true;
                if (dfs(board, x, y + 1)) return true;
                board[x][y] = '.';
                row[x][i] = col[y][i] = sodu[x / 3][y / 3][i] = false;
            }
        }
        return false;
    }
}
