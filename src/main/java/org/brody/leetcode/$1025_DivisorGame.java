package org.brody.leetcode;

/**
 * 1025. 除数博弈
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divisor-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $1025_DivisorGame {
    /**
     * 数字 N 如果是奇数，它的约数必然都是奇数；若为偶数，则其约数可奇可偶。
     * 无论 N 初始为多大的值，游戏最终只会进行到 N=2 时结束，那么谁轮到 N=2 时谁就会赢。
     * 因为爱丽丝先手，N 初始若为偶数，爱丽丝则只需一直选 1，使鲍勃一直面临 N 为奇数的情况，这样爱丽丝稳赢；
     * N 初始若为奇数，那么爱丽丝第一次选完之后 N 必为偶数，那么鲍勃只需一直选 1 就会稳赢。
     * 综述，判断 N 是奇数还是偶数，即可得出最终结果！
     * <p>
     * 作者：coder233
     * 链接：https://leetcode-cn.com/problems/divisor-game/solution/qi-shi-shi-yi-dao-shu-xue-ti-by-coder233/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

}
