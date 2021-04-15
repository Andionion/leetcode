package org.brody.leetcode.base;

import lombok.Data;

/**
 * 二叉树结点
 *
 * @author CYF
 */
@Data
public class TreeNode {
    public int val;
    /**
     * 左节点
     */
    public TreeNode left;
    /**
     * 右节点
     */
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
