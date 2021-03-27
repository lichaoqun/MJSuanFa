package 链表;
/*
 * https://leetcode-cn.com/problems/reverse-linked-list/submissions/
 * */
public class _206_反转链表 {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
    }
	
	public ListNode reverseList2(ListNode head) {
		ListNode lastNode = null;		
		while (head != null){
			ListNode temp = head.next;
			head.next = lastNode;
			lastNode = head;
			head = temp;
		} ;
		ListNode newHead = lastNode;
		return newHead;
    }
	
	public static void main(String[] args) {
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(4);
    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	
    	_206_反转链表 s = new _206_反转链表();
		System.out.println(l1);
		System.out.println(s.reverseList2(l2));
	}
}
