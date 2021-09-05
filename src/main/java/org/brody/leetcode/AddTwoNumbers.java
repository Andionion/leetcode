package org.brody.leetcode;

import org.brody.leetcode.base.ListNode;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 将两个链表看成是相同长度的进行遍历, 如果链表较短, 则在前面补0, 如 987 + 23 = 987 + 023 = 1010;
        // 每一位计算的同时要考虑上一位的进位问题, 而当前计算结束后同样需要更新进位值
        // 如果两个链表都遍历完成后, 进位值为1, 则在新链表的最前方添加节点1
        // 小技巧: 对于链表问题, 返回结果为头结点时, 通常需要先初始化一个预先指针 pre, 该指针的下一个节点指向真正的头结点head.
        // 目的在于链表初始化时无可用节点值, 而且链表构造过程中需要指针移动, 进而会导致头指针丢失, 无法返回结果
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        // 进位值
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;
            carry = sum / 10;
            sum %= 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(7, new ListNode(8, new ListNode(9)));
        ListNode listNode2 = new ListNode(3, new ListNode(2));
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode);
    }
}