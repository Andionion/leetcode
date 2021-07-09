package org.brody.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CYF
 */
public class $0017_LetterCombinationOfPhoneNumber {
    private static Map<String, String> phone = new HashMap<>() {
        private static final long serialVersionUID = -869834773528506190L;

        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    private static List<String> output = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }

    private static void backtrack(String combination, String nextDigits) {
        //如果所有数字已经确认, 则添加完毕
        if (nextDigits.length() == 0) {
            output.add(combination);
        } else {
            //遍历map中所有的字母
            String digit = nextDigits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(combination + letter, nextDigits.substring(1));
            }
        }
    }

}
