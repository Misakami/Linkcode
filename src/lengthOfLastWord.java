public class lengthOfLastWord {
    /**
     * 超级简单的dp？？？
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        s = s.trim();
        int res = 0;
        int nowlength = 0;
        for (char word : s.toCharArray()
                ) {
            if (word == ' ') {
                nowlength = 0;
            }else {
                nowlength++;
                res = nowlength;
            }
        }
        return res;
    }

    /**
     * 果然自己的脑子不够好使。。。
     * @param s
     * @return
     */
    public int lengthOfLastWord2(String s) {
        return s.trim().length() - s.trim().lastIndexOf(' ') -1;
    }
}
