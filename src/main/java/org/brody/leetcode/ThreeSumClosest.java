package org.brody.leetcode;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * <p>
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int target = 1;
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        //首先对数组排序
        Arrays.sort(nums);
        //ans为最小的三数之和
        int ans = nums[0] + nums[1] + nums[2];
        //每遍历一个值，形成固定值nums[i]，再使用前指针start指向i+1，使用后指针指向nums.length-1
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            //根据sum = nums[i] + nums[start] + nums[end]的结果，判断sum与目标target的距离，如果更近，则更新ans
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                //同时判断sum和target的大小，因为数组有序，如果sum大于target，则end--；小于则start++；等于，说明找到，直接返回结果
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
