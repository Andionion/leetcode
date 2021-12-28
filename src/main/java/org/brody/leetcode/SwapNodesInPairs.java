package org.brody.leetcode;

import org.brody.leetcode.base.ListNode;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class SwapNodesInPairs {


    public ListNode swapPairs(ListNode head) {
        // 虚拟头结点， 指向头结点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 充当后面的虚拟头结点
        ListNode p = dummyHead;

        while (p.next != null && p.next.next != null) {
            // 设置三个指针，两个需要交换的节点node1和node2，还有一个node3指向node2.next
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;
            // node2.next设置为node1，node1.next设置为node3，虚拟头结点指向node2
            node2.next = node1;
            node1.next = node3;
            p.next = node2;

            p = node1;
        }


        return dummyHead.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode listNode1 = swapNodesInPairs.swapPairs(listNode);
        System.out.println(listNode1);
    }
}
