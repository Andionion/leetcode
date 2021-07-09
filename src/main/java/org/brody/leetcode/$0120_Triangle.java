package org.brody.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author CYF
 */
public class $0120_Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        //自底向上，不用考虑边界问题
        //一维数组dp，每次计算一层(i,j)位置的数到底部的最小距离和时，当前层只跟它的下一层有关系，所以我们只用保留下一层的结果就可以，
        //用一维数组，一直更新这个一维数组就可以
        int row = triangle.size();
        int[] dp = new int[row + 1];

        for (int i = row - 1; i >= 0; i--) {
            //第i行有i+1个数字
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        Random random = new Random();

        for (int i = 1; i < 5; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                list.add(random.nextInt(10) + 1);
            }
            triangle.add(list);
        }

        System.out.println(minimumTotal(triangle));
    }
}
