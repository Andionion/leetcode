package org.brody.leetcode;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度～= 500,000），而 s 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * <p>
 * （例如，"ace" 是 "abcde" 的一个子序列，而 "aec" 不是）。
 * <p>
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false.
 * <p>
 * 后续挑战 :
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10 亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char c : s.toCharArray()) {
            int j = t.indexOf(c, i);
            if (j == -1) {
                return false;
            }
            i = j + 1;
        }
        return true;
    }

	/*public boolean isSubsequence(String s, String t) {

		//记dp[i][j]为s的0到i的子字符串是否为t的0到j的子字符串的子序列
		//若s[i]==t[j]，则判断dp[i][j]是否为true取决于dp[i-1][j-1]
		//若s[i]！=t[j]，则判断dp[i][j]是否为true取决于dp[i][j-1]
		int sLen = s.length();
		int tLen = t.length();
		if (sLen > tLen) {
			return false;
		}
		if (sLen == 0) {
			return true;
		}
		boolean[][] dp = new boolean[sLen + 1][tLen + 1];

		//初始化
		for (int i = 0; i < tLen; i++) {
			dp[0][i] = true;
		}
		//dp
		for (int i = 1; i <= sLen; i++) {
			for (int j = 1; j <= tLen; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		return dp[sLen][tLen];
	}*/
}
