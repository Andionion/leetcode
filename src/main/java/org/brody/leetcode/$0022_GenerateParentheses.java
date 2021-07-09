package org.brody.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0022_GenerateParentheses {
    public static List<String> generateParentheses(int n) {
        //回溯法意味着，每一次先求出一个
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private static void backtrack(List<String> res, String cur, int open, int close, int max) {
        //如果当前字符的长度为max*2，表示已经有了max个成对的括号
        if (cur.length() == max * 2) {
            res.add(cur);
            return;
        }

        //每加入一个左括号，意味着开区间又加了一个。
        if (open < max) {
            backtrack(res, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(res, cur + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> strings = generateParentheses(n);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
