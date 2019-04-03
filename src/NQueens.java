import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题，还是传说中回溯法
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        if ( n <= 0 )
            return null;
        List<List<String>> res = new ArrayList<>();
        help(res,new int[n],n,0);
        return res;
    }
    public void help(List<List<String>> res,int[] queens,int n,int pos){
        if (n == pos){
            List<String>  list = new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j <n ; j++) {
                    if (queens[i] == j){
                        sb.append('Q');
                    }else sb.append('.');
                }
                list.add(sb.toString());
            }
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            queens[pos] = i;
            if (couldPut(queens,pos)){
                help(res,queens,n,pos+1);
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
