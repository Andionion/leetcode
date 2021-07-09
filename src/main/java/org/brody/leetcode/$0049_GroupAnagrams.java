package org.brody.leetcode;

import java.util.*;

/**
 * @author CYF
 */
public class $0049_GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat", "bta"};
        $0049_GroupAnagrams solution = new $0049_GroupAnagrams();
        List<List<String>> lists = solution.groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        //将每个字符串按照字母顺序排序，这样的话就可以把eat，tea，ate都映射到aet
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            //排序
            Arrays.sort(chars);
            //映射到key
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(key, temp);
            }
        }
        return new ArrayList<>(map.values());
    }


}
