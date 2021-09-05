package org.brody.leetcode;

import org.brody.leetcode.base.ListNode;

/**
 * 19. 删除链表的倒数第 N 个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cyf
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;
        ListNode listNode1 = removeNthNodeFromEndOfList.removeNthFromEnd(listNode, n);
        System.out.println(listNode1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 设置一个头结点, 指向 head
        // 设置两个指针 start 和 end, start 首先移动 n, 然后start 和 end 一起向后移动
        // 当 start 移动到尾端的时候, 此时 end 恰好指在倒数第 n 个节点
        // 因为要删除节点,所以必须要移动到该节点的前面才可以删除, 所以循环结束条件是 start.next!=null
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode start = pre, end = pre;

        while (n != 0) {
            start = start.next;
            n--;
        }

        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;

        return pre.next;
    }
}
