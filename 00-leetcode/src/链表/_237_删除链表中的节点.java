package 链表;
/*
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * */
public class _237_删除链表中的节点 {

	// - 实现
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
	    node.next = node.next.next;
	}

	// - 测试
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = null;
		
		_237_删除链表中的节点 s = new _237_删除链表中的节点();
		System.out.println(l1.val + "," + l1.next.val + "," + l1.next.next.val + "," + l1.next.next.next.val);
		s.deleteNode(l2);
		System.out.println(l1.val + "," + l1.next.val + "," + l1.next.next.val);
		
	}

}