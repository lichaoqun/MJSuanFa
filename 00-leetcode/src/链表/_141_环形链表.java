package 链表;
/*
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * */
public class _141_环形链表 {
	
	// - 快慢指针
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) return false;
		ListNode slowNode = head;
		ListNode fastNode = head.next;
		while (fastNode != null && fastNode.next != null) {
			if (fastNode == slowNode) return true;
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}
		return false;
    }

	// - 递归比标记
	public boolean hasCycle2(ListNode head) {
		if (head == null || head.next == null) return false;
		if (head.val == 0x0abce) return true;
		
		head.val = 0x0abce;
		return hasCycle2(head.next);
		
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = null;
		
		_141_环形链表 s = new _141_环形链表();
		System.out.println(s.hasCycle2(l1));
		l4.next = l2;
		System.out.println(s.hasCycle2(l1));
	}
}
