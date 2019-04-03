import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringtoInteger {
    public static void main(String[] args) {
        Solution1 a = new Solution1();
        System.out.println(a.myAtoi("+4193"));
    }
}
class Solution1 {
    public int myAtoi(String str){
        str = str.replaceAll("\\s*", "");
        System.out.println(str);
        String pattern = "^(\\+|-)?\\d+";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        int i=0;
        if (m.matches()) {
            System.out.println(m.group());
            try {
                i = Integer.parseInt(m.group());
            }catch (NumberFormatException e){
                if (m.group().charAt(0)=='-')
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
        }
        return i;
    }
}