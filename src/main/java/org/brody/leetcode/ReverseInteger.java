package org.brody.leetcode;

/**
 * 7. 整数反转
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为[2<sup>31</sup>, 2<sup>31</sup>-1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int reverse = reverse(-2147483648);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        int result = 0;
        int pop;
        while (x != 0) {
            pop = x % 10;
            boolean isOverMaxInteger = result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && pop > 7;
            boolean isLowerMinInteger = result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && pop < -8;
            if (isLowerMinInteger || isOverMaxInteger) {
                return 0;
            }
            result = result * 10 + pop;
            x /= 10;
        }
        return result;
    }
}
