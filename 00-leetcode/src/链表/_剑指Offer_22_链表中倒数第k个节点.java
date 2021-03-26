/**
 * 
 */
package 链表;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class _剑指Offer_22_链表中倒数第k个节点 {
	private int count = 1;
	private ListNode newNode = null;
	public ListNode getKthFromEnd(ListNode head, int k) {
		if (head == null || head.next == null) return head;
		ListNode node = getKthFromEnd(head.next, k);
		if (k == count) newNode = node;
		count++;
		return (newNode == null) ? head : newNode;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_剑指Offer_22_链表中倒数第k个节点 s = new _剑指Offer_22_链表中倒数第k个节点();

		ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(4);
    	ListNode l5 = new ListNode(5);
    	ListNode l6 = new ListNode(6);
    	ListNode l7 = new ListNode(7);
    	
    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;
    	l5.next = l6;
    	l6.next = l7;
    	System.out.println(s.getKthFromEnd(l1, 3));
	}

}
