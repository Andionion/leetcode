package org.brody.leetcode;

/**
 * 96.不同的二叉搜索树
 *
 * @author CYF
 */
public class $0096_UniqueBinarySearchTrees {
    public int numTrees(int n) {
        //记 n 个节点存在二叉排序树的个数为 G(n)，令 f(i) 为以 i 为根的二叉搜索树的个数
        //则 G(n) = f(0) + f(1) + f(2) + ... + f(n)
        //又以 i 为根的左子树个数为 i - 1，右子树个数为 n - i
        //则 f(i) = G(i - 1) * G (n - i)
        //则 G(n) = G(0) * G(n-1) + G(1) * G(n - 2) + ... + G(n - 1) * G(0)
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
