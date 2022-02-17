package org.brody.leetcode;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/<p>
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = {1, 2, 3, 8, 5, 7, 7, 6, 1};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        // 从后往前找到第一个升序的位置
        int i = -1;
        int j = -1;
        for (int k = nums.length - 1; k > 0; k--) {
            if (nums[k] > nums[k - 1]) {
                i = k - 1;
                j = k;
                break;
            }
        }
        // 如果没有找到升序的位置，则将数组排序
        if (i == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // 从 j 开始往后找到第一个比 nums[i] 大的数，更新 j 的值
        for (int k = j + 1; k < nums.length; k++) {
            if (nums[k] > nums[i]) {
                j = k;
            }
        }
        // 交换大数和小数的值
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
        // 将 i 后面的数字逆转
        reverse(nums, i + 1, nums.length - 1);
    }

    /**
     * 逆转数组
     *
     * @param nums  数组
     * @param start 开始位置
     * @param end   结束位置
     */
    private void reverse(int[] nums, int start, int end) {
        // 如果 start > end，则直接返回
        if (start >= end) {
            return;
        }
        // 交换 start 和 end 位置的数字
        nums[start] = nums[start] ^ nums[end];
        nums[end] = nums[start] ^ nums[end];
        nums[start] = nums[start] ^ nums[end];
        // 将 start 后面的数字逆转
        reverse(nums, start + 1, end - 1);
    }
}
