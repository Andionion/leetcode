package org.brody.leetcode;

import java.util.Arrays;

/**
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 * <p>
 * 给出时间复杂度为 O(n*sizeof(integer)) 的解答非常容易。但你可以在线性时间 O(n) 内用一趟扫描做到吗？
 * 要求算法的空间复杂度为 O(n)。
 * 你能进一步完善解法吗？要求在 C++ 或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0338_CountingBits {
    public static void main(String[] args) {
        $0338_CountingBits test = new $0338_CountingBits();
        int[] nums = test.countBits(2);
        System.out.println(Arrays.toString(nums));
    }

    public int[] countBits(int num) {
        //偶数二进制的最后一位一定为0，奇数二进制的最后一位一定为1
        //若num为偶数，那么它的1的个数一定和num/2的1的个数相等，因为除以2等于往右移1位
        //若num为奇数，那么它的1的个数 = num/2的1的个数 + 1，原因同上，往右移 1 位，最后一位1没有了
        int[] dp = new int[num + 1];
        if (num == 0) {
            return new int[1];
        }
        if (num == 1) {
            return new int[]{0, 1};
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= num + 1; i++) {
            dp[i] = i % 2 == 0 ? dp[i / 2] : dp[i / 2] + 1;
        }
        return dp;
    }
}
