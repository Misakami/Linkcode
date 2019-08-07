package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GroupAnagrams {

    /**
     *  想法是通过一个特定的值来表示字母一样的单词 hashmap 可以完成
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String s:strs
             ) {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            if (!map.containsKey(String.valueOf(a))) map.put(String.valueOf(a),new ArrayList<String>() );
            map.get(String.valueOf(a)).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
