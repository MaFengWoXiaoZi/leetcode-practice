package algorithm;

import utils.ListNode;

/**
 *ʱ�临�Ӷ�O(n)
 *�ռ临�Ӷ�O(n)
 *�㷨˼��, ����������Ľ��ֵ���, ���Խ�����ͷ��������ת��Ϊ��ͷ��������Ӷ��������,
 *��Ҫ���ǽ�λ, ��˶�ÿ������ֵ��ӵĽ����10�ֱ�ȡ������ȡ��, 
 *��Ҫ�������һ����ӿ��ܽ�λ�����
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
