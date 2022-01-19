package org.brody.leetcode;

/**
 * 28. 实现strStr()
 * <p>
 * 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从 0 开始)。如果不存在，则返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class ImplementStr {

    public int strStr(String haystack, String needle) {
        int len = needle.length();
        int lenHay = haystack.length();
        // 如果 needle 是空字符串时，应当返回 0
        if (len == 0) {
            return 0;
        }
        // 如果 needle 字符串长度大于 haystack 长度，那么返回 -1
        if (lenHay < len) {
            return -1;
        }
        // 截取 haystack 中 needle 长度的字符串，判断是否和 needle 相等
        // 结束循环条件是指针移动到距离 haystack 字符串末尾 needle 长度的位置
        int start = 0;
        while (start + len - 1 < lenHay) {
            if (haystack.substring(start, start + len).equals(needle)) {
                return start;
            }
            start++;
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStr implementStr = new ImplementStr();
        String haystack = "a";
        String needle = "a";
        System.out.println(implementStr.strStr(haystack, needle));
    }

}
