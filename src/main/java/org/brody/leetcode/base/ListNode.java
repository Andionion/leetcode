package org.brody.leetcode.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 链表类
 *
 * @author CYF
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode create(int[] vals) {
        if (vals == null || vals.length == 0) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode cur;
        cur = head;
        for (int val : vals) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(String.valueOf(val));
        while (next != null) {
            str.append("->").append(next.val);
            next = next.next;
        }
        return str.toString();
    }
}
