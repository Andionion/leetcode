package org.brody.leetcode.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 二叉树结点
 *
 * @author CYF
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
