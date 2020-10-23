package org.brody.leetcode;

/**
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0014_LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		//当字符串数组长度为0时，公共前缀为空，直接返回
		if (strs.length == 0) {
			return "";
		}
		//令最长公共前缀ans的值为第一个字符串，进行初始化
		String ans = strs[0];
		//遍历后面的字符串，依次将其与ans两两进行比较，找出公共前缀，最终结果为最长公共前缀
		for (int i = 1; i < strs.length; i++) {
			int j = 0;
			for (; j < ans.length() && j < strs[i].length(); j++) {
				if (ans.charAt(j) != strs[i].charAt(j)) {
					break;
				}
			}
			ans = ans.substring(0, j);
			//如果查找过程中ans为空，意味着后续不需要再比较了
			if ("".equals(ans)) {
				return ans;
			}
		}
		return ans;
	}
}
