package org.brody.leetcode;

/**
 * @author CYF
 */
public class $0009_PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		char[] chars = Integer.toString(x).toCharArray();
		int left = 0;
		int right = chars.length - 1;

		while (left <= right) {
			if (chars[left] == chars[right]) {
				left++;
				right--;
			} else {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		$0009_PalindromeNumber solution = new $0009_PalindromeNumber();
		System.out.println(solution.isPalindrome(-10));
	}
}
