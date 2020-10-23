package org.brody.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CYF
 */
public class $0013_RomanToInteger {

	public int romanToInt(String s) {
		Map<String, Integer> map = new HashMap<>(13);
		map.put("M", 1000);
		map.put("CM", 900);
		map.put("D", 500);
		map.put("CD", 400);
		map.put("C", 100);
		map.put("XC", 90);
		map.put("L", 50);
		map.put("XL", 40);
		map.put("X", 10);
		map.put("IX", 9);
		map.put("V", 5);
		map.put("IV", 4);
		map.put("I", 1);

		int res = 0;
		int len = s.length();
		for (int i = 0; i < len; ) {
			if (i + 1 < len && map.containsKey(s.substring(i, i + 2))) {
				res += map.get(s.substring(i, i + 2));
				i += 2;
			} else {
				res += map.get(s.substring(i, i + 1));
				i++;
			}
		}
		return res;
	}
}
