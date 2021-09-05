package org.brody.leetcode;

import org.brody.leetcode.base.ListNode;

/**
 * 23. 合并 K 个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class MergeSortedLists {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = new ListNode[3];
        lists[0] = listNode1;
        lists[1] = listNode2;
        lists[2] = listNode3;
        MergeSortedLists mergeSortedLists = new MergeSortedLists();
        ListNode listNode = mergeSortedLists.mergeSortedLists(lists);
        System.out.println(listNode);
    }

    public ListNode mergeSortedLists(ListNode[] lists) {
        // 采用分治法，将 K 个链表先划分为 K/2 个链表，处理它们的合并，然后不停的向下划分，直到划分成只有一个或两个链表的任务，开始合并
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }


        int mid = lists.length / 2;
        ListNode[] left = new ListNode[mid];
        System.arraycopy(lists, 0, left, 0, mid);
        ListNode[] right = new ListNode[lists.length - mid];
        System.arraycopy(lists, mid, right, 0, lists.length - mid);

        return mergeTwoLists(mergeSortedLists(left), mergeSortedLists(right));

    }

    /**
     * 合并两个有序链表
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;

    }

}
