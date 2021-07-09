package org.brody.leetcode;

/**
 * 50. Pow(x,n)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0050_Pow {

    public static double myPow(double x, int n) {
        // 我们可以使用n的二进制表示来更好的理解问题
        // 从最低位开始，对于第i位，如果bi=1，意味着我们要将结果累乘以pow(x,pow(2,i))

        long signNum = n;
        if (signNum < 0) {
            x = 1 / x;
            signNum = -signNum;
        }

        double ans = 1;
        double currentProduct = x;

        for (long i = signNum; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans *= currentProduct;
            }
            currentProduct *= currentProduct;
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 10;
        System.out.println(myPow(x, n));
    }
}































