package org.brody.leetcode;

/**
 * 11. 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * <p>
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0011_ContainerWithMostWater {
	/**
	 * 设定双指针分别指向最前端和最后端, 然后短板减一格, 同时更新最大值
	 */
	public static int maxArea(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int area = 0;
		while (i < j) {
			area = height[i] < height[j] ? Math.max(area, (j - i) * height[i++]) : Math.max(area, (j - i) * height[j--]);
		}
		return area;
	}
}
