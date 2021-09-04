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
public class GenerateParentheses {
    public static List<String> generateParentheses(int n) {
        // 回溯法意味着，每一次先求出一个
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private static void backtrack(List<String> res, String cur, int open, int close, int max) {
        // 结束条件，当字符串长度为 2 倍的 max 之后，意味着已经找到了成对的括号
        if (max * 2 == cur.length()) {
            res.add(cur);
            return;
        }

        // 添加一个左括号
        if (open < max) {
            backtrack(res, cur + "(", open + 1, close, max);
        }
        // 对左括号进行闭合
        if (close < open) {
            backtrack(res, cur + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        List<String> strings = generateParentheses(n);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
