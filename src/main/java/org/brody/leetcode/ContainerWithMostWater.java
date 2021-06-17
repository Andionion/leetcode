package org.brody.leetcode;

/**
 * 11. 盛最多水的容器
 * <p>
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i,   ai) 。
 * <p>
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,   ai) 和 (i, 0)。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * <p>
 * 输出：49
 * <p>
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 * <p>
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * <p>
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：height = [4,3,2,1,4]
 * <p>
 * 输出：16
 * <p>
 * 示例 4：
 * <p>
 * 输入：height = [1,2,1]
 * <p>
 * 输出：2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 提示：
 * <p>
 * n = height.length
 * <p>
 * 2 <= n <= 3 * 104
 * <p>
 * 0 <= height[i] <= 3 * 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {4, 3, 2, 1, 4};
        int i = maxArea(height);
        System.out.println(i);
    }

    /**
     * 设定双指针分别指向最前端和最后端, 然后短板减一格, 同时更新最大值
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left < right) {
            area = height[left] < height[right] ? Math.max(area, (right - left) * height[left++]) : Math.max(area, (right - left) * height[right--]);
        }
        return area;
    }

}
