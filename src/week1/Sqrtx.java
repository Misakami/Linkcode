package week1;

public class Sqrtx {
    /**
     * sqrt 计算平法根 下取整
     */
    int mySqrt(int x) {
        int l = 0, r = x;
        while (l < r) {
            int mid = (int) (r +(long)l + 1 >> 1);
            if (mid <= x / mid) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}
