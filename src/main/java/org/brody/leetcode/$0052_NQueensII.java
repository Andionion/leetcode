package org.brody.leetcode;

/**
 * 52. N皇后II
 * <p>
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * <p>
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0052_NQueensII {

    private int[] rows;
    /**
     * 横纵坐标相减，最小为-(n-1), 为防止负数下标，扩大了范围，直接加上2n
     */
    private int[] hills;
    /**
     * 横纵坐标相加，不会超过2n-2
     */
    private int[] dales;
    private int n;
    private int ans = 0;


    public int totalNQueens(int n) {

        this.n = n;
        rows = new int[n];
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        backtrack(0);
        return ans;
    }


    private void backtrack(int row) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                //如果n个皇后已经被放置完成
                if (row + 1 == n) {
                    ans++;
                } else {
                    //如果没有放置完成
                    backtrack(row + 1);
                }
                //回溯
                removeQueen(row, col);
            }
        }
    }

    private void removeQueen(int row, int col) {
        rows[col] = 0;
        hills[row - col + 2 * n] = 0;
        dales[row + col] = 0;
    }


    private boolean isNotUnderAttack(int row, int col) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return res == 0;
    }

    private void placeQueen(int row, int col) {
        rows[col] = 1;
        hills[row - col + 2 * n] = 1;
        dales[row + col] = 1;
    }
}
