package week4;


/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromicSubstring {
    //马拉车算法

    /**
     *   基本思想 ： 回文串拥有中心点 可能是奇数可能是偶数 分开搜索
     */
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i,k = i; j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k) ; j--,k++) {
                if (res.length() < k - j +1){
                    System.out.println(j+" "+k);
                    res = s.substring(j,k+1);
                }
            }
            for (int j = i,k = i + 1; j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k) ; j--,k++) {
                if (res.length() < k - j + 1){
                    res = s.substring(j,k+1);
                }
            }
        }
        return res;
    }
}
