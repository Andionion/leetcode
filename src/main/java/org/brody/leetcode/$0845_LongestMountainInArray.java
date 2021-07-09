package org.brody.leetcode;

/**
 * 2019/8/19 商汤科技笔试
 * 845. 数组中的最长山脉
 * <p>
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * <p>
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * <p>
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * <p>
 * 如果不含有 “山脉” 则返回 0。
 * <p>
 *
 * @author CYF
 */
public class $0845_LongestMountainInArray {
    public static int longestMountain(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            //如果当前数字大于左右两边的数字，前指针前移和后指针后移。
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                int l = i - 1;
                int r = i + 1;
                //前指针大于0，且当前数字大于前一个数字，前指针继续前移
                while (l > 0 && nums[l] > nums[l - 1]) {
                    l--;
                }
                //后指针小于长度并且当前数字大于后一个数字，后指针继续后移
                while (r < nums.length - 1 && nums[r] > nums[r + 1]) {
                    r++;
                }
                //更新“山脉长度”。
                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }

}
