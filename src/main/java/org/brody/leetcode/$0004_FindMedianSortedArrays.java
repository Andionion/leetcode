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
public class $0004_FindMedianSortedArrays {
	//基本思路是比较两个数组中第k小的数, 小的那组的前k/2个数可以直接排除, 一直到k=1或者其中某个数组排除完.
	//前者所求数为两个数组中此时最小的那个数, 后者为长的那个数组的第k个数字

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int left = (n + m + 1) / 2;
		int right = (n + m + 2) / 2;
		//将偶数和奇数的情况合并,如果是奇数,会求两次同样的 k
		return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
	}

	private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
		int len1 = end1 - start1 + 1;
		int len2 = end2 - start2 + 1;

		//让len1的长度小于len2,这样就能保证如果有数组空了, 一定是len1
		if (len1 > len2) {
			return getKth(nums2, start2, end2, nums1, start1, end1, k);
		}
		//当第一个数组为空的时候, 跳出递归, 直接返回第二个数组特定值即可
		if (len1 == 0) {
			return nums2[start2 + k - 1];
		}
		//当k=1的时候, 跳出递归, 返回第一个数组和第二个数组最小的那个值
		if (k == 1) {
			return Math.min(nums1[start1], nums2[start2]);
		}

		//比较两个数组的第 k/2 个数字, 哪个数字小, 就去掉哪个数组的前k/2个数字, 然后继续递归
		int i = start1 + Math.min(len1, k / 2) - 1;
		int j = start2 + Math.min(len2, k / 2) - 1;
		if (nums1[i] > nums2[j]) {
			return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
		} else {
			return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
		}
	}
}
