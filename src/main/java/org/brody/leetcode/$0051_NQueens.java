package org.brody.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 * <p>
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0051_NQueens {
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
    private List<List<String>> output = new ArrayList<>();
    private int[] queenPosition;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        rows = new int[n];
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        queenPosition = new int[n];
        backtrack(0);
        return output;
    }

    private void backtrack(int row) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                //如果n个皇后已经被放置完成
                if (row + 1 == n) {
                    addSolution();
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
        queenPosition[row] = 0;
        rows[col] = 0;
        hills[row - col + 2 * n] = 0;
        dales[row + col] = 0;
    }

    private void addSolution() {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int col = queenPosition[i];
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < col; j++) {
                stringBuilder.append(".");
            }
            stringBuilder.append("Q");
            for (int j = 0; j < n - col - 1; j++) {
                stringBuilder.append(".");
            }
            solution.add(stringBuilder.toString());
        }
        output.add(solution);
    }

    private boolean isNotUnderAttack(int row, int col) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return res == 0;
    }

    private void placeQueen(int row, int col) {
        queenPosition[row] = col;
        rows[col] = 1;
        hills[row - col + 2 * n] = 1;
        dales[row + col] = 1;
    }
}



































