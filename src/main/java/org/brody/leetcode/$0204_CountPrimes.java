package org.brody.leetcode;

import java.util.Arrays;

/**
 * 204. 计数质数
 * <p>
 * 统计所有小于非负整数 n 的质数的数量
 * <p>
 * 示例：
 * 输入：10
 * <p>
 * 输出：4
 * <p>
 * 解释：小于 10 的质数一共有 4 个，它们是 2，3，5，7
 *
 * @author cyf
 */
public class $0204_CountPrimes {

    public static int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);

        //排除法，对每一个数字，倍数都不是质数
        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(countPrimes(n));
    }
}
