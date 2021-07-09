package org.brody.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 54. 螺旋矩阵
 * <p>
 * 给定一个包含 m x n 个元素的矩阵（m 行，n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0054_SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        /*一层一层取，设左上角坐标为（r1，c1），右下角坐标为（r2，c2）
         * 如果当前层是一个圈而不是一行或者一列，则应该是
         * top：（r1，c）-> c 从 c1 到 c2，
         * right：（r，c2） -> r 从 r1+1 到 r2，
         * bottom：（r2，c）-> c 从 c2-1 到 c1+1
         * left：（r，c1） -> r 从 r2-1 到 r1+1
         * 其中必须保证r1<r2和c1<c2，才进行向左和向上的循环
         * */

        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) {
            return ans;
        }
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                ans.add(matrix[r1][c]);
            }
            for (int r = r1 + 1; r <= r2; r++) {
                ans.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    ans.add(matrix[r2][c]);
                }
                for (int r = r2; r > r1; r--) {
                    ans.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 4;
        int[][] matrix = new int[m][n];
        Random random = new Random();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        List<Integer> list = spiralOrder(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("--------------");

        System.out.println(list.toString());
    }
}
