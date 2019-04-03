public class MultiplyString {
    /**
     * 分析数字相乘的规律总结算法
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "0";
        }
        int[] digits = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + digits[i + j + 1];
                int p1 = sum / 10;
                int p2 = sum % 10;
                digits[i + j] += p1;
                digits[i + j + 1] = p2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int digit : digits
                ) {
            if (sb.length()!=0||digit!=0){
                sb.append(digit);
            }
        }
        if (sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }
}
