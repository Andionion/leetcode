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

    public ListNode(int[] vals) {
        if (vals == null || vals.length == 0) {
            return;
        }
        val = vals[0];
        ListNode cur = this;
        for (int i = 1, valsLength = vals.length; i < valsLength; i++) {
            int val = vals[i];
            cur.next = new ListNode(val);
            cur = cur.next;
        }
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
