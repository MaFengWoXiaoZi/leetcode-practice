package algorithm;

import utils.ListNode;

/**
 *时间复杂度O(n)
 *空间复杂度O(n)
 *算法思想, 对两个链表的结点值相加, 可以将不带头结点的链表转化为带头结点的链表从而方便计算,
 *需要考虑进位, 因此对每次两个值相加的结果对10分别取余数和取商, 
 *还要考虑最后一次相加可能进位的情况
 * @author Haoran
 *
 */

public class AddTwoNumbers {
	public ListNode addTwoNumber(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode p = head;
		ListNode p1 = l1;
		ListNode p2 = l2;
		int sum = 0;
		
		while (p1 != null || p2 != null) {
			if (p1 != null) {
				sum += p1.val;
				p1 = p1.next;
			}
			if (p2 != null) {
				sum += p2.val;
				p2 = p2.next;
			}
			
			p.next = new ListNode(sum % 10);
			p = p.next;
			sum /= 10;
		}
		
		if (sum == 1) {
			p.next = new ListNode(1);
			p.next.next = null;
		}
		
		return head.next;
	}
}
