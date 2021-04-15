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
public class $0025_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        //分为三部分，已翻转，待翻转，未翻转
        //初始需要两个变量pre和end，pre表示待翻转链表的前驱，end表示待翻转链表的末尾。

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        //当end的next不为空时，表示需要翻转
        while (end.next != null) {
            //end指向当前第k个结点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            //如果此时end为null，说明未翻转区域小于k，则直接跳出循环，直接返回。
            if (end == null) {
                break;
            }
            //start指向待翻转的头结点
            ListNode start = pre.next;
            //next指向下一个待翻转的头结点
            ListNode next = end.next;
            //把待翻转和未翻转隔离开
            end.next = null;
            //已翻转的末尾指向待翻转翻转之后的头结点，此时头结点为待翻转之前的end
            pre.next = reverse(start);
            //此时start结点为待翻转的尾结点
            start.next = next;

            //更新pre和end的位置
            pre = start;
            end = pre;

        }
        return dummy.next;
    }

    /**
     * 翻转待翻转链表
     */
    private ListNode reverse(ListNode head) {
        //设置两个指针
        ListNode pre = null;
        ListNode cur = head;
        //因为已经把待翻转和未翻转隔离开，所以用null作为循环结束条件
        while (cur != null) {
            //下一个要翻转的节点
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
