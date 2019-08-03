package week1;

public class BinarySearch {

    /**
     * 模板1 r = mid情况
     * 将区间转化成 【1，r】 ->【l，mid】 【mid+1，r】 r=mid 或者 r = mid + 1 避免出现死循环
     */
    int bsearch(int l, int r) {
        while (l < r) {
            int mid = r + l >> 1;
            if (check(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    /**
     * 模板2  l= mid情况
     * 将区间转化成 【1，r】 ->【l，mid - 1】 【mid ，r】 l = mid 或者 r = mid -1 避免出现死循环
     */
    int bsearch2(int l, int r) {
        while (l < r) {
            int mid = r + l + 1 >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    /**
     * 判断区域划分条件
     */
    private boolean check(int mid) {
        return true;
    }


    /**
     * sqrt 计算平法根 下取整
     */

    int mySqrt(int x) {
        int l = 0, r = x;
        while (l < r) {
            int mid = r + l + 1 >> 1;
            if (mid <= x / mid) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}
