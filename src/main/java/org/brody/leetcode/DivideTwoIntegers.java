package org.brody.leetcode;

/**
 * 29. 两数相除
 * <p>
 * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数dividend除以除数divisor得到的商。
 * <p>
 * 示例1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * <p>
 * 示例2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231− 1]。本题中，如果除法结果溢出，则返回 231− 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        // 1表示正数，-1表示负数
        int flag = 1;
        // 把除数和被除数转为负数来计算，因为负数边界的绝对值比正数大，负数变成正数会越界，但是正数变成负数不会越界
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend > 0) {
            dividend = -dividend;
        } else {
            flag = -flag;
        }
        if (divisor > 0) {
            divisor = -divisor;
        } else {
            flag = -flag;
        }

        int s = 0, temp, k;
        while (dividend <= divisor) {
            temp = divisor;
            k = 1;
            // 类似于位运算，都是2的n次方多项式，每一次的k都是当前2的n次方的值，n不断减小，系数都是除数。
            // 拆解为多个除数乘以 2 的 n 次方多项式，将这多个 2 的 n 次方的值相加即为两数之商
            // temp + temp < 0 是为了防止死循环。
            while (dividend <= temp + temp && temp + temp < 0) {
                temp += temp;
                k += k;
            }
            s += k;
            dividend -= temp;
        }

        return flag > 0 ? s : -s;
    }

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        System.out.println(divide(13, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(Integer.MIN_VALUE, 1));
    }
}
