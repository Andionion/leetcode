package org.brody.leetcode;

/**
 * 287. 寻找重复数
 * <p>
 * 给定一个包含 n+1 个整数的数组 nums，其数字都在 1 到 n 之间
 * <p>
 * （包含 1 和 n），可知至少存在一个重复的整数。假设只有一个重
 * <p>
 * 复的整数，找出这个重复的数
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,3,4,2,2,]
 * <p>
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：[3,1,3,4,2]
 * <p>
 * 输出：3
 * <p>
 * 说明：
 * <p>
 * 1.不能更改原数组（假设数组是只读的）
 * <p>
 * 2. 只能使用额外的 O(1) 的空间
 * <p>
 * 3. 时间复杂度小于 O(n*n)
 * <p>
 * 4. 数组只有一个重复的数字，但它可能不止重复一次
 *
 * @author cyf
 */
public class $0287_FindtheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        // 利用二分法，start 和 end 指针指向两端
        // 按条件，如果没有重复数字小于等于 mid 的数字至多有 mid 个
        int length = nums.length;
        int start = 1;
        int end = length - 1;
        int mid;

        while (start < end) {
            mid = start + (end - start) / 2;
            int counter = 0;
            for (int num : nums) {
                if (num <= mid) {
                    counter++;
                }
            }

            if (counter > mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
