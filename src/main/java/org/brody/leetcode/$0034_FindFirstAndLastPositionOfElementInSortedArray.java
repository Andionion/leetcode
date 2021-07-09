package org.brody.leetcode;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class $0034_FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        //因为是排序过的nums，所以先找到target位置，然后向后遍历，找到最后一个位置
        int length = nums.length;
        int firstIndex = -1;
        int lastIndex = -1;
        int left = 0;
        int right = length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                int temp = mid;
                firstIndex = mid;
                lastIndex = mid;
                //向左向右遍历，找到下标，要在[left,right]范围内遍历
                while (mid > left && nums[mid] == nums[mid - 1]) {
                    mid--;
                    firstIndex = mid;
                }
                while (temp < right && nums[temp] == nums[temp + 1]) {
                    temp++;
                    lastIndex = temp;
                }
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return new int[]{firstIndex, lastIndex};
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
