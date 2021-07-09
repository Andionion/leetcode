package org.brody.leetcode;

/**
 * 121. 买卖股票的最佳时机
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0121_BestTimeToBuyAndSellStock {


    /**
     * 寻找谷和峰
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfile = 0;
        for (int i = 0; i < prices.length; i++) {
            //寻找波谷，如果此时的值比此时的波谷大，判断是否大于最大利润，若是，则更新最大利润
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > maxProfile) {
                maxProfile = prices[i] - min;
            }
        }
        return maxProfile;
    }


    /**
     * 这是一个最大连续子数组和的问题，牛顿莱布尼茨公式可知，区间和可以转化为求差的问题，求差问题也可以转换为区间和问题
     * 最大连续字数和可以用动态规划求解，dp[i]表示以i结尾的最大连续子数组和，递推公式为 dp[i]=max(0, dp[i-1]+diff[i]);
     */
	/*public int maxProfit(int[] prices) {
		//last为最大连续子树和，profile为最大利润
		int last = 0, profile = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			//更新last
			last = Math.max(0, last + prices[i + 1] - prices[i]);
			profile = Math.max(profile, last);
		}
		return profile;
	}*/
}
