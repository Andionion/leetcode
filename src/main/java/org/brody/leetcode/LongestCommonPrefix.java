package org.brody.leetcode;

import cn.hutool.core.util.RandomUtil;

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
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[100000];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = RandomUtil.randomString(RandomUtil.BASE_CHAR, 3);
        }
        long startTime = System.currentTimeMillis();
        System.out.println("ssss" + longestCommonPrefix(strs));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String longestCommonPrefix(String[] strs) {

        int len = strs.length;
        // 空数组
        if (len == 0) {
            return "";
        }
        // 数组中只有一个字符串时
        if (len == 1) {
            return strs[0];
        }
        //先默认第一个字符串为公共前缀 然后依次减少一个字符比较
        String result = strs[0];
        // 否则依次比较判断 选第一个字符串与剩下的依次比较
        for (int i = 0; i < len; i++) {
            // 当与后面的字符串匹配不符合时，截取result
            // 如果与第二个没有匹配到前缀，后面的字符串就不要再匹配了
            if (!strs[i].startsWith(result)) {
                result = result.substring(0, result.length() - 1);
                i--;
            }
        }
        return result;
    }
}
