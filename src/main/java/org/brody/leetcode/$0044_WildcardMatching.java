package org.brody.leetcode;

/**
 * 44. 通配符匹配
 * <p>
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 * <p>
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 * <p>
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 * <p>
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0044_WildcardMatching {
    public boolean isMatch(String s, String p) {
        //动态规划四要素：状态、转移方程、初始化、结果
        //状态：f[i][j]表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
        //转移方程：
        // 1. 如果 s 的第 i 个字符和 p 的第 j 个字符相同，或者 p 的第 j 个字符为 ？，f[i][j] = f[i - 1][ j - 1]
        // 2. 如果 p 的第 j 个字符为 *
        // 2.1 若 p 的第 j 个字符匹配空字符串，则 f[i][j] = f[i][j - 1]
        // 2.2 若 p 的第 j 个字符匹配 s 的第 i 个字符，则 f[i][j] = f[i - 1][j]。注意这里不是 f[i - 1][j - 1]， 举个例子， (abc, a*) f[3][2]=f[2][2]
        //初始化：f[0][0] = true，f[0][i] = f[0][i - 1] && p[i] == '*'
        //结果：f[s.length][p.length]
        int m = s.length(), n = p.length();
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        boolean[][] dp = new boolean[m + 1][n + 1];

        //初始化
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] && pChars[i - 1] == '*';
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (sChars[i - 1] == pChars[j - 1] || pChars[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (pChars[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}



































