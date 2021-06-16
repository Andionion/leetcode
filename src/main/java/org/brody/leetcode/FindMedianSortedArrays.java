package org.brody.leetcode;

/**
 * 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author CYF
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 6};
        int[] nums2 = {4, 7, 8};

        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    /**
     * 基本思路是比较两个数组中第k小的数, 小的那组的前k/2个数可以直接排除, 一直到k=1或者其中某个数组排除完.
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并,如果是奇数,会求两次同样的 k
        return (getKth(nums1, 0, nums2, 0, left) + getKth(nums1, 0, nums2, 0, right)) * 0.5;
    }

    /**
     * @param nums1 数组 1
     * @param i     nums1 的起始位置
     * @param nums2 数组 2
     * @param j     nums2 的起始位置
     * @param k     中位数
     */
    private static int getKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            // nums1 为空数组
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            // nums2 为空数组
            return nums1[i + k - 1];
        }
        if (1 == k) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = i + k / 2 - 1 < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = j + k / 2 - 1 < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        // 比较两个数组中位数大小，把小的那个数组的前 k/2 个数字去除
        return midVal1 < midVal2 ? getKth(nums1, i + k / 2, nums2, j, k - k / 2) : getKth(nums1, i, nums2, j + k / 2, k - k / 2);
    }
}
