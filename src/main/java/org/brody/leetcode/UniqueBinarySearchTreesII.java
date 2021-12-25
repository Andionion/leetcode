package org.brody.leetcode;

import org.brody.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树II
 *
 * @author CYF
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        return getAns(1, n);
    }

    private List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        //此时没有数字，将null加入结果中
        if (start > end) {
            ans.add(null);
            return ans;
        }

        //只有一个数字，当前数字作为一棵树加入结果中
        if (start == end) {
            TreeNode tree = new TreeNode(start);
            ans.add(tree);
            return ans;
        }

        //尝试每个节点作为根节点
        for (int i = start; i <= end; i++) {
            //得到可能的左子树
            List<TreeNode> leftTrees = getAns(start, i - 1);
            //得到可能的右子树
            List<TreeNode> rightTrees = getAns(i + 1, end);
            //左右子树两两结合
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    //加入到最终结果中
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
