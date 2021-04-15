package org.brody.leetcode;

import org.brody.leetcode.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层次遍历
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *
 * @author cyf
 */
public class $0103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> print(TreeNode root) {

        //思路，做两个栈，一个奇数行，一个偶数行
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        ArrayDeque<TreeNode> oddStack = new ArrayDeque<>();
        ArrayDeque<TreeNode> evenStack = new ArrayDeque<>();

        oddStack.push(root);
        int layer = 1;

        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            while (layer % 2 == 1 && !oddStack.isEmpty()) {
                TreeNode node = oddStack.pop();
                temp.add(node.val);
                if (node.left != null) {
                    evenStack.push(node.left);
                }
                if (node.right != null) {
                    evenStack.push(node.right);
                }

            }
            while (layer % 2 != 1 && !evenStack.isEmpty()) {
                TreeNode node = evenStack.pop();

                temp.add(node.val);
                if (node.right != null) {
                    oddStack.push(node.right);
                }
                if (node.left != null) {
                    oddStack.push(node.left);
                }
            }

            if (temp.size() != 0) {
                ans.add(temp);
            }
            layer++;
        }
        return ans;
    }
}
