import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RegexMatches {
    public static void main(String[] args) {
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        hashSet.add("1");
        hashSet.add("3");
        hashSet.add("2");
        hashSet.add("4");
        LinkedHashSet<String> hashSet1 = (LinkedHashSet<String>) new HashSet<String>();
        hashSet1.add("2");
        Set<String> set = hashSet;
        LinkedHashSet<String> a = (LinkedHashSet<String>) hashSet1;
        for (String b:a
             ) {
            System.out.println(b);
        }
    }
}
