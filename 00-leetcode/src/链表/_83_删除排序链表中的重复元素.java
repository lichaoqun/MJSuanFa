package 链表;
/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * */
public class _83_删除排序链表中的重复元素 {

	public ListNode deleteDuplicates(ListNode head) {
		
		ListNode newHead = new ListNode(1000);
		ListNode lastNode = newHead;
		while (head != null) {
			lastNode.next = null;
			if (head.val != lastNode.val) {
				lastNode.next = head;
				lastNode = lastNode.next;
			}
			head = head.next;
		}
		return newHead.next;
    }
	
	public ListNode deleteDuplicates1(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode node = deleteDuplicates1(head.next);
		if (head.val == node.val) {
			head.next = node.next;
		}
		return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_83_删除排序链表中的重复元素 s = new _83_删除排序链表中的重复元素();

		ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(1);
    	ListNode l3 = new ListNode(1);
    	ListNode l4 = new ListNode(3);
    	ListNode l5 = new ListNode(6);
    	ListNode l6 = new ListNode(5);
    	ListNode l7 = new ListNode(5);
    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;
    	l5.next = l6;
    	l6.next = l7;
    	l7.next = null;
    	System.out.println(l1);
    	System.out.println(s.deleteDuplicates(l1));
	}

}
