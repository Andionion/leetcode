package org.brody.leetcode;

/**
 * 10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0010_RegularExpressionMatching {
	public static boolean isMatch(String s, String p) {
		/*
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
		boolean[][] dp = new boolean[sArr.length + 1][pArr.length + 1];

		dp[0][0] = true;


		for (int i = 1; i <= pArr.length; i++) {
			//dp[0][i] = pArr[i - 1] == star ? dp[0][i - 2] : false;
			dp[0][i] = pArr[i - 1] == star && dp[0][i - 2];
		}

		for (int i = 1; i <= sArr.length; i++) {
			for (int j = 1; j <= pArr.length; j++) {
				/*
				 * p[j]是字母, 并且s[i]==p[j], 当前子问题成立与否取决于子问题s[0...i-1]和p[0...j-1]是否成立
				 * p[j]是'.', 当前子问题是否成立取决于子问题s[0...i-1]和p[0...j-1]是否成立
				 */
				if (sArr[i - 1] == pArr[j - 1] || pArr[j - 1] == point) {
					// 看 s[0,...i-1] 和 p[0,...j-1]
					dp[i][j] = dp[i - 1][j - 1];
				}

				/*
				 * p[j]是'*', s[i]==p[j-1], 或者p[j-1]是'.', 当前子问题是否成立取决于子问题s[0...i-1]和p[0...j]是否成立
				 * p[j]是'*', s[i]!=p[j-1], 当前子问题正确与否取决于子问题s[0...i]是否匹配p[0...j-2]
				 */

				if (pArr[j - 1] == star) {
					//看 s[0,...i] 和 p[0,...j-2]
					dp[i][j] |= dp[i][j - 2];

					if (pArr[j - 2] == sArr[i - 1] || pArr[j - 2] == point) {
						//看 s[0,...i-1] 和 p[0,...j]
						dp[i][j] |= dp[i - 1][j];
					}
				}
			}
		}
		return dp[sArr.length][pArr.length];
	}


	/**
	 * 备忘录
	 *//*
	public static boolean isMatch(String s, String p) {
		*//*
	 * 假设要考虑的问题是考虑s的第i个字母, p的第j个字母, 所以这时候的子问题是s[0...i]和p[0...j]是否成立
	 * p[j]是字母, 并且s[i]!=p[j], 当前子问题不成立
	 * p[j]是字母, 并且s[i]==p[j], 当前子问题成立与否取决于子问题s[0...i-1]和p[0...j-1]是否成立
	 * p[j]是'.', 当前子问题是否成立取决于子问题s[0...i-1]和p[0...j-1]是否成立
	 * p[j]是'*', s[i]==p[j-1], 或者p[j-1]是'.', 当前子问题是否成立取决于子问题s[0...i-1]和p[0...j]是否成立
	 * p[j]是'*', s[i]!=p[j-1], 当前子问题正确与否取决于子问题s[0...i]是否匹配p[0...j-2]
	 *//*

		if (s.equals(p)) {
			return true;
		}

		//备忘录
		boolean[] memo = new boolean[s.length() + 1];

		return helper(s.toCharArray(), p.toCharArray(), s.length() - 1, p.length() - 1, memo);
	}

	private static boolean helper(char[] s, char[] p, int i, int j, boolean[] memo) {
		if (memo[i + 1]) {
			return true;
		}

		if (i == -1 && j == -1) {
			memo[i + 1] = true;
			return true;
		}

		boolean isFirstMatching = false;

		*//*
	 * p[j]是字母, 并且s[i]!=p[j], 当前子问题不成立
	 * p[j]是字母, 并且s[i]==p[j], 当前子问题成立与否取决于子问题s[0...i-1]和p[0...j-1]是否成立
	 * p[j]是'.', 当前子问题是否成立取决于子问题s[0...i-1]和p[0...j-1]是否成立
	 * p[j]是'*', s[i]==p[j-1], 或者p[j-1]是'.', 当前子问题是否成立取决于子问题s[0...i-1]和p[0...j]是否成立
	 * p[j]是'*', s[i]!=p[j-1], 当前子问题正确与否取决于子问题s[0...i]是否匹配p[0...j-2]
	 *//*
		char point = '.';
		char star = '*';
		//boolean pIsAlpha = s[i] == p[j];
		//boolean pIsPoint = p[j] == point;
		//boolean pIsStar = p[j] == star && (s[i] == p[j - 1] || p[j - 1] == point);
		boolean pJudge = i >= 0 && j >= 0 && (s[i] == p[j] || p[j] == point || (p[j] == star && (p[j - 1] == s[i] || p[j - 1] == point)));

		//最后一位是否匹配
		if (pJudge) {
			isFirstMatching = true;
		}

		if (j >= 1 && p[j] == star) {
			//看s[0...i]和p[0...j-2]
			//此时判断0...i, 所以不用判断首位是否匹配
			boolean zero = helper(s, p, i, j - 2, memo);
			//看s[0...i-1]和p[0...j]
			boolean match = isFirstMatching && helper(s, p, i - 1, j, memo);

			if (zero || match) {
				memo[i + 1] = true;
			}
			return memo[i + 1];
		}

		//看s[0...i-1]和p[0...j-1]
		if (isFirstMatching && helper(s, p, i - 1, j - 1, memo)) {
			memo[i + 1] = true;
		}
		return memo[i + 1];
	}*/
}
