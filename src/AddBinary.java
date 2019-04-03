public class AddBinary {

    /**
     * 非常简单的二进制相加，主要是学到了倒序输出sb的值。。。
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int remainder = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = remainder;
            if (i != 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j != 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            sb.append(sum % 2);
            remainder = sum / 2;
        }
        if (remainder != 0) {
            sb.append(remainder);
        }
        return sb.reverse().toString();
    }
}
