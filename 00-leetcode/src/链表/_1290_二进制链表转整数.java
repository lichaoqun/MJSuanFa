package 链表;

public class _1290_二进制链表转整数 {
	private int count = 1;
	public int getDecimalValue(ListNode head) {
		if (head.next == null) return head.val;
		int last = getDecimalValue(head.next);
		int sum = head.val * (int)Math.pow(2, count) + last;
		count++;
		return sum;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(0);
    	ListNode l3 = new ListNode(1);
    	l1.next = l2;
    	l2.next = l3;
    	l3.next = null;
    	
    	_1290_二进制链表转整数 s = new _1290_二进制链表转整数();
		System.out.println(s.getDecimalValue(l1));
	}
}
