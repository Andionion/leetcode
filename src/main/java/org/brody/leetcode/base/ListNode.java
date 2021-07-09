package org.brody.leetcode.base;

import lombok.Data;

/**
 * 链表类
 *
 * @author CYF
 */
@Data
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

}
