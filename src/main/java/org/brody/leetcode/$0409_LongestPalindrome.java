package org.brody.leetcode;

/**
 * 409. 最长回文串
 * <p>
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * @author CYF
 */
public class $0409_LongestPalindrome {
    /**
     * 创建一个大小为52的数组存放大小写字母，取偶数
     */
    public int longestPalindrome(String s) {
        int[] counter = new int[58];

        for (char c : s.toCharArray()) {
            counter[c - 'A']++;
        }

        int res = 0;
        for (int i : counter) {
            // 字符最多使用偶数次
            res += i - (i & 1);
        }

        // 如果最终的长度小于原字符串长度，说明还可以再加一个在中间
        return res < s.length() ? res + 1 : res;

    }
}
