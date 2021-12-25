package org.brody.leetcode;

import org.brody.leetcode.base.Node;

/**
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * <p>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有next 指针都被设置为 NULL。
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * <p>
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author brody
 * @date 2021/12/25
 */
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    /**
     * 输入两个节点，将它俩连接起来
     *
     * @param left
     * @param right
     */
    private void connectTwoNode(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        /* 前序遍历位置 **/
        // 将传入的两个节点连接
        left.next = right;

        // 连接相同父节点的两个子节点
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);

        // 连接跨越父节点的两个子节点
        connectTwoNode(left.right, right.left);
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode populatingNextRightPointersInEachNode = new PopulatingNextRightPointersInEachNode();
        Node root = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(7)));
        Node connect = populatingNextRightPointersInEachNode.connect(root);
        System.out.println(connect);
    }
}
