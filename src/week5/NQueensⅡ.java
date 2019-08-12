package week5;


/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */

public class NQueensⅡ {
    int res = 0;
    public int totalNQueens(int n) {
        if ( n <= 0 )
            return 0;
        help(new int[n],n,0);
        return res;
    }
    public void help(int[] queens,int n,int pos){
        if (n == pos){
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            queens[pos] = i;
            if (couldPut(queens,pos)){
                help(queens,n,pos+1);
            }
        }
    }
    public boolean couldPut(int[] queens,int pos){
        for (int i = 0; i < pos; i++) {
            if (queens[i] == queens[pos]){
                return false;
            }else if (Math.abs(pos-i)==Math.abs(queens[i]-queens[pos])){
                return false;
            }
        }
        return true;
    }
}
