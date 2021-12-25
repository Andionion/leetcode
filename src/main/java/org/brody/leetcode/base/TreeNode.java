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

    public void print() {
        System.out.println("前序遍历输出：");
        printPreOrder();
        System.out.println();
        System.out.println("中序遍历输出：");
        printInOrder();
        System.out.println();
        System.out.println("后序遍历输出：");
        printPostOrder();
        System.out.println();
    }

    /**
     * 后序遍历输出
     */
    public void printPostOrder() {
        if (left != null) {
            left.printPostOrder();
        }
        if (right != null) {
            right.printPostOrder();
        }
        System.out.print(val + " ");
    }

    /**
     * 中序遍历输出
     */
    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.print(val + " ");
        if (right != null) {
            right.printInOrder();
        }
    }

    /**
     * 前序遍历
     */
    public void printPreOrder() {
        System.out.print(val + " ");
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
    }
}
