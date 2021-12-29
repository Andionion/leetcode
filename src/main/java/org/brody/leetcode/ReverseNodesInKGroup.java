package org.brody.leetcode;

import org.brody.leetcode.base.ListNode;

/**
 * 25. K个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 首选初始化开始和结束结点
        ListNode start, end;
        start = end = head;
        // 循环，将 end 指向下一个需要翻转的组的开头结点
        for (int i = 0; i < k; i++) {
            // 如果此时不足 k 个，意味着不用翻转了
            if (end == null) {
                return head;
            }
            end = end.next;
        }
        // 翻转此时的 start 到 end 链表
        ListNode newHead = reverse(start, end);
        // 将翻转后的链表递归并连接起来(start此时为翻转后的最后一个结点）
        start.next = reverseKGroup(end, k);
        return newHead;
    }

    /**
     * 翻转区间[a,b)之间的链表，左闭右开
     *
     * @param a
     * @param b
     * @return
     */
    private ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, next;
        pre = null;
        cur = next = a;
        // while 终止条件 next 不为 b
        while (next != b) {
            // next 往指向下一个待翻转的结点
            next = cur.next;
            // 当前结点翻转
            cur.next = pre;
            // pre往右移动一位，指向当前结点
            pre = cur;
            // cur 往右移动一位，指向刚才待翻转的结点
            cur = next;
        }
        // 返回翻转后的头结点
        return pre;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        int[] vals = {1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(vals);
        System.out.println(listNode);
        ListNode listNode1 = reverseNodesInKGroup.reverseKGroup(listNode, 2);
        System.out.println(listNode1);
        ListNode listNode2 = reverseNodesInKGroup.reverseKGroup(listNode, 3);
        System.out.println(listNode2);
    }

}
