package week4;


/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 *   题目考虑了好久- -
 *
 */public class CountAndSay {
    public String countAndSay(int n) {
        return say(n);
    }

    private String say(int n) {
        String res = "1";
        StringBuilder stringBuilder ;
        for (int i = 1; i < n; i++) {
            stringBuilder = new StringBuilder();
            char resChar = res.charAt(0);
            int  num= 0;
            for (int j = 0; j < res.length(); j++) {
                if (resChar == res.charAt(j)){
                    num++;
                }else {
                    stringBuilder.append(num);
                    stringBuilder.append(resChar);
                    num = 1;
                    resChar = res.charAt(j);
                }
            }
            stringBuilder.append(num);
            stringBuilder.append(resChar);
            res = stringBuilder.toString();
        }
        return res;
    }
}

