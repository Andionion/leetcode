package org.brody.leetcode;

import org.brody.base.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author CYF
 */
public class $0024_SwapNodesInPairs {
	//设置三个指针，两个需要交换的节点node1和node2，还有一个node3指向node2.next
	//node2.next设置为node1，node1.next设置为node3，虚拟头结点指向node2

	public ListNode swapPairs(ListNode head) {
		//虚拟头结点， 指向头结点
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;

		//充当后面的虚拟头结点
		ListNode p = dummyHead;

		while (p.next != null && p.next.next != null) {
			ListNode node1 = p.next;
			ListNode node2 = node1.next;
			ListNode node3 = node2.next;

			node2.next = node1;
			node1.next = node3;
			p.next = node2;

			p = node1;
		}


		return dummyHead.next;
	}
}
