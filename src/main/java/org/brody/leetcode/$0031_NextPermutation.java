package org.brody.leetcode;

/**
 * 31. 下一个排列
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
public class $0031_NextPermutation {
    public void nextPermutation(int[] nums) {
        //使用两个指针index1和index2，遍历数组，从后往前首先判断第一个nums[i]>nums[i-1]的i值，index1指向i-1，index2指向i-2.
        int index1 = -1, index2 = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index1 = i - 1;
                index2 = i;
                break;
            }
        }
        //当遍历完之后index1依然是-1，代表这个数字是降序的，将其翻转成升序即可
        if (index1 == -1) {
            up(nums, 0, nums.length - 1);
            return;
        }
        //然后从index2依次向后遍历，到最后一个大于nums[index1]的位置，交换此时的nums[index1]和nums[index2]
        for (int i = index2; i < nums.length; i++) {
            if (nums[i] > nums[index1]) {
                index2 = i;
            }
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;

        //最后将nums[index1]之后的数字重新升序排列
        up(nums, index1 + 1, nums.length - 1);


    }

    private void up(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
