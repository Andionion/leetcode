package org.brody.leetcode;

import org.brody.leetcode.base.TreeNode;

/**
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * <p>
 * /   \
 * <p>
 * 2     7
 * <p>
 * / \   / \
 * <p>
 * 1   3 6   9
 * <p>
 * 输出：
 * <p>
 * 4
 * <p>
 * /   \
 * <p>
 * 7     2
 * <p>
 * / \   / \
 * <p>
 * 9   6 3   1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author brody
 * @date 2021/12/25
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        // 对二叉树的前序遍历，根结点翻转左右，然后左右结点
        // base case
        if (root == null) {
            return null;
        }

        // 翻转左右节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 翻转左节点
        invertTree(root.left);
        // 翻转右节点
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        root.print();
        System.out.println("翻转后");
        TreeNode treeNode = invertBinaryTree.invertTree(root);
        treeNode.print();
    }
}
