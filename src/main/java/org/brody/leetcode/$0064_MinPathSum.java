package org.brody.leetcode;

/**
 * 64. 最小路径和
 * <p>
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0064_MinPathSum {
    public int minPathSum(int[][] grid) {
        //自底向上，在原数组上更改，最后输出[0][0]点
        //最后一列时，直接向下走，最后一行时，直接向右走，否则计算下和右最小的那个值
        int row = grid.length;
        int col = grid[0].length;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                //最后一行时，直接向右走
                if (i == row - 1 && j != col - 1) {
                    grid[i][j] += grid[i][j + 1];

                }
                //最后一列时，直接向下走
                else if (i != row - 1 && j == col - 1) {
                    grid[i][j] += grid[i + 1][j];
                }
                //否则计算下和右最小的那个值
                else if (i != row - 1 && j != col - 1) {
                    grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
                }
            }
        }
        return grid[0][0];
    }
}
