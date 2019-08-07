package week4;


/**
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 *
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 *
 *  . 字符不代表小数点，而是用于分隔数字序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-version-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        int i = 0,j = 0;
        while (i < version1.length() || j < version2.length()){
            int v1 = 0;
            int v2 = 0;
            while (i < version1.length()  && version1.charAt(i) != '.'){
                v1 += v1*10 + (version1.charAt(i) - '0');
                i++;
            }
            i++;
            while (j < version2.length()  && version2.charAt(j) != '.'){
                v2 += v2*10 + (version2.charAt(j) - '0');
                j++;
            }
            j++;
            if (v1 < v2) return -1;
            if (v1 > v2) return 1;
        }
        return 0;
    }
}
