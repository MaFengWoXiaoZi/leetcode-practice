package test;

import algorithm.AddTwoNumbers;
import utils.ListNode;

public class TestAddTwoNumbers {
	
	public static void printAllNode(ListNode l) {
		ListNode.print(l);
		while (l.next != null) {
			l = l.next;
			ListNode.print(l);
		}
	}
	
	public static void main(String[] args) {
		AddTwoNumbers solution = new AddTwoNumbers();
		
		ListNode l1 = new ListNode(2);
		ListNode l1_2 = new ListNode(4);
		ListNode l1_3 = new ListNode(3);
		l1.next = l1_2;
		l1_2.next = l1_3;
		l1_3.next = null;
		
		ListNode l2 = new ListNode(5);
		ListNode l2_2 = new ListNode(6);
		ListNode l2_3 = new ListNode(4);
		l2.next = l2_2;
		l2_2.next = l2_3;
		l2_3.next = null;
		
		ListNode res = solution.addTwoNumber(l1, l2);
		printAllNode(res);
		
	}

}
