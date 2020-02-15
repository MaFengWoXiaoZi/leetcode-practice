package utils;

/*
 * 单链表结点定义
 */
public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(int x) {
		val = x;
	}
	
	public static void print(ListNode node) {
		System.out.print(node.val);
	}
}
