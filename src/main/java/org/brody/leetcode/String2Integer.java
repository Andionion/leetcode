package org.brody.leetcode;

/**
 * 8. 字符串转换整数 (atoi)
 * <p>
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cyf
 */
public class String2Integer {
    public static int myAtoi(String str) {
        str = str.trim();
        // 符号位
        boolean sign = false;
        //最终转换出来的,只有数字的字符串
        String result = null;
        //只有当字符串不为空时才进行转换
        if (str.isEmpty()) {
            return 0;
        }
        //判断第一个字符是否是+-或者数字
        char aChar = str.charAt(0);
        if (aChar == '+' || aChar == '-') {
            sign = aChar == '-';
            //判断数字开始的索引
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    result = str.substring(1, i + 1);
                } else {
                    break;
                }
            }
        } else if (aChar >= '0' && aChar <= '9') {
            //这时候循环只要数字
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    result = str.substring(0, i + 1);
                } else {
                    break;
                }
            }
        }


        //判断最终字符串是否为空,或者只有一个正负号
        if (result == null || "+".equals(result) || "-".equals(result)) {
            return 0;
        }

        int num = 0;
        for (int i = 0; i < result.length(); i++) {
            int cur = result.charAt(i) - '0';
            if (sign) {
                if (num < Integer.MIN_VALUE / 10 || num == Integer.MIN_VALUE / 10 && cur > 8) {
                    return Integer.MIN_VALUE;
                }
                num = num * 10 - cur;
            } else {
                if (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && cur > 7) {
                    return Integer.MAX_VALUE;
                }
                num = num * 10 + cur;
            }
        }

        return num;
    }

    public static void main(String[] args) {

        int i = String2Integer.myAtoi("words 4432");
        System.out.println(i);


    }
}
