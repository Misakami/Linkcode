package week4;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 很简单的反转
 */
public class ReverseString {

    public String reverseWords(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String word = "";
            while (i < s.length() && s.charAt(i) == ' ') i++;
            while (i < s.length() && s.charAt(i)!= ' '){
                word += s.charAt(i);
                i++;
            }
            if (word.length() > 0 && res.length() > 0) word+=" ";
            word += res;
            res = word;
        }
        return res;
    }
}
