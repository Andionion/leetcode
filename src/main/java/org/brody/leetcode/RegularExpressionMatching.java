package org.brody.leetcode;

/**
 * 10. 正则表达式匹配
 * <p>
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * <p>
 * '*' 匹配零个或多个前面的那一个元素
 * <p>
 * 所谓匹配，是要涵盖整个字符串 s 的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * <p>
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa" p = "a"
 * <p>
 * 输出：false
 * <p>
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * <p>
 * 输入：s = "aa" p = "a*"
 * <p>
 * 输出：true
 * <p>
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * 示例  3：
 * <p>
 * 输入：s = "ab" p = ".*"
 * <p>
 * 输出：true
 * <p>
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "aab" p = "c*a*b"
 * <p>
 * 输出：true
 * <p>
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * <p>
 * 示例 5：
 * <p>
 * 输入：s = "mississippi" p = "mis*is*p*."
 * <p>
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length  <= 20
 * <p>
 * 0 <= p.length  <= 30
 * <p>
 * s  可能为空，且只包含从  a-z  的小写字母。
 * <p>
 * p  可能为空，且只包含从  a-z  的小写字母，以及字符  .  和  *。
 * <p>
 * 保证每次出现字符  * 时，前面都匹配到有效的字符
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        boolean match = isMatch(s, p);
        System.out.println(match);
    }

    public static boolean isMatch(String s, String p) {
        /*
         * 这里s是String，p是pattern
         *
         * 假设要考虑的问题是考虑s的第i个字母, p的第j个字母, 所以这时候的子问题是s[0...i]和p[0...j]是否成立
         * p[j]是字母, 并且s[i]!=p[j], 当前子问题不成立
         * p[j]是字母, 并且s[i]==p[j], 当前子问题成立与否取决于子问题s[0...i-1]和p[0...j-1]是否成立
         * p[j]是'.', 当前子问题是否成立取决于子问题s[0...i-1]和p[0...j-1]是否成立
         * p[j]是'*', s[i]==p[j-1], 或者p[j-1]是'.', 当前子问题是否成立取决于子问题s[0...i-1]和p[0...j]是否成立
         * p[j]是'*', s[i]!=p[j-1], 当前子问题正确与否取决于子问题s[0...i]是否匹配p[0...j-2]
         */
        if (s.equals(p)) {
            return true;
        }

        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        char point = '.';
        char star = '*';

        // 下面开始填写初始条件，类似于斐波那契的第一个和第二个数字， 这里创建的数组中，全部都是false
        boolean[][] dp = new boolean[sArr.length + 1][pArr.length + 1];
        // 要初始化第0行和第0列，来作为初始数据，第一列中除了第一个为true，其他均为false
        dp[0][0] = true;
        // 初始化第0行
        for (int i = 0; i < pArr.length; i++) {
            // 如果p[i]为*,因为*是匹配前一个字母，可以有任意个，包括0个，所以要看dp[0][i-2]是否为true
            dp[0][i + 1] = pArr[i] == star && dp[0][i - 1];
        }

        for (int i = 0; i < sArr.length; i++) {
            for (int j = 0; j < pArr.length; j++) {
                /*
                 * p[j]是字母, 并且s[i]==p[j], 当前子问题成立与否取决于子问题s[0...i-1]和p[0...j-1]是否成立
                 * p[j]是'.', 当前子问题是否成立取决于子问题s[0...i-1]和p[0...j-1]是否成立
                 */
                if (sArr[i] == pArr[j] || pArr[j] == point) {
                    // 看 s[0,...i-1] 和 p[0,...j-1]
                    dp[i + 1][j + 1] = dp[i][j];
                }

                /*
                 * p[j]是'*', 当前子问题正确与否取决于子问题s[0...i]是否匹配p[0...j-2]
                 * p[j]是'*', s[i]==p[j-1]或者p[j-1]是'.'时, 当前子问题是否成立取决于子问题s[0...i-1]和p[0...j]成立或者子问题s[0...i]是否匹配p[0...j-2]成立
                 */

                if (pArr[j] == star) {
                    //看 s[0,...i] 和 p[0,...j-2]
                    dp[i + 1][j + 1] = dp[i + 1][j - 1];

                    if (sArr[i] == pArr[j - 1] || pArr[j - 1] == point) {
                        //看 s[0,...i-1] 和 p[0,...j]或者s[0,...i] 和 p[0,...j-2]
                        dp[i + 1][j + 1] |= dp[i][j + 1];
                    }
                }
            }
        }
        return dp[sArr.length][pArr.length];
    }
}
