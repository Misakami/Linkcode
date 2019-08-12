package week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */


public class PhoneNumber {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> res = new ArrayList<String>(){{
        add("");
    }
    };

    public List<String> letterCombinations(String digits) {
        if( digits.length() == 0) return res;
        //循环遍历做法
        for (int i = 0; i < digits.length() ; i++) {
            String num = phone.get(digits.substring(i,i+1));
            List<String> tempres = new ArrayList<>();
            for (int j = 0; j < num.length(); j++) {
                for (String s: res) {
                    s = s + num.charAt(j);
                    tempres.add(s);
                }
            }
            res = tempres;
        }

        //helper(digits, "", 0);
        return res;
    }

    /**
     * 基础的回溯法
     */
    private void helper(String digits, String s, int i) {
        if (i == digits.length()) {
            res.add(s);
            return;
        }
        String num = phone.get(digits.substring(i,i+1));

        for (int k = 0; k < num.length(); k++) {
            s = s + num.charAt(k);
            helper(digits, s, i + 1);
            s = s.substring(0, s.length() - 1);
        }
    }
}
