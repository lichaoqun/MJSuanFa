package 链表;
/*
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * */
public class _1290_二进制链表转整数 {
	private int count = 1;
	public int getDecimalValue(ListNode head) {
		if (head.next == null) return head.val;
		int last = getDecimalValue(head.next);
		int sum = head.val * (int)Math.pow(2, count) + last;
		count++;
		return sum;
	}
	
	private int count1 = 0;
	public int getDecimalValue1(ListNode head) {
		if (head == null) return 0;
		int last = getDecimalValue1(head.next);
		int sum = head.val * (int)Math.pow(2, count1) + last;
		count1++;
		return sum;
	}
	
	public int getDecimalValue2(ListNode head) {
		int result = 0;
		while (head != null) {
	        result  = (result << 1) + head.val;
			head = head.next;
		}
		return result;
	}
	
	public ListNode toDecimalValue2(int value) {
		ListNode last = null;
		while (value != 0) {
			int s = value % 2;
			ListNode curNode = new ListNode(s);
			curNode.next = last;
			last = curNode;
			value = value >> 1;
		}
		return last;
	}
	
	public ListNode node(ListNode head) {

		/** 迭代 10111
		  	while (head != null) {
				System.out.println(head);
				head = head.next;
			}
			return null;
		
		 * 	1->0->1->1->1->null
			0->1->1->1->null
			1->1->1->null
			1->1->null
			1->null 
		 * */
		
		
		/** 迭代 10111
			while (head.next != null) {
				System.out.println(head);
				head = head.next;
			}
			return null;
			
		 * 	1->0->1->1->1->null
			0->1->1->1->null
			1->1->1->null
			1->1->null
		 * */
		
		
		/** 递归 10111  
			if (head == null) return head;
			ListNode last = node(head.next);
			System.out.println("head: " + head + ", last:" + last);
			return head;

		 * 	head: 1->null, last:null
			head: 1->1->null, last:1->null
			head: 1->1->1->null, last:1->1->null
			head: 0->1->1->1->null, last:1->1->1->null
			head: 1->0->1->1->1->null, last:0->1->1->1->null
		 * */
		

		/** 递归 10111
			if (head.next == null) return head;	
			ListNode last = node(head.next);
			System.out.println("head: " + head + ", last:" + last);
			return head;	
			
		 * 	head: 1->1->null, last:1->null
			head: 1->1->1->null, last:1->1->null
			head: 0->1->1->1->null, last:1->1->1->null
			head: 1->0->1->1->1->null, last:0->1->1->1->null
		 * */
		return null;
	}

	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(0);
    	ListNode l3 = new ListNode(1);
    	ListNode l4 = new ListNode(1);
    	ListNode l5 = new ListNode(1);
    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;
    	
    	_1290_二进制链表转整数 s = new _1290_二进制链表转整数();
		System.out.println(s.getDecimalValue2(l1));
		System.out.println(s.toDecimalValue2(23));
	}
}
