package org.brody.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * put("2", "abc");
 * <p>
 * put("3", "def");
 * <p>
 * put("4", "ghi");
 * <p>
 * put("5", "jkl");
 * <p>
 * put("6", "mno");
 * <p>
 * put("7", "pqrs");
 * <p>
 * put("8", "tuv");
 * <p>
 * put("9", "wxyz");
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * <p>
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * <p>
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class LetterCombinationOfPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationOfPhoneNumber letterCombinationOfPhoneNumber = new LetterCombinationOfPhoneNumber();
        String digits = "23";
        System.out.println(JSONObject.toJSONString(letterCombinationOfPhoneNumber.letterCombinations(digits)));
    }

    private final Map<String, String> phoneMap = new HashMap<>() {
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

    private final List<String> output = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }

    private void backtrack(String combination, String nextDigits) {
        // 如果所有数字已经确认, 则添加完毕
        if (nextDigits.length() == 0) {
            output.add(combination);
        } else {
            // 遍历map中所有的字母
            String digit = nextDigits.substring(0, 1);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phoneMap.get(digit).substring(i, i + 1);
                backtrack(combination + letter, nextDigits.substring(1));
            }
        }
    }

}
