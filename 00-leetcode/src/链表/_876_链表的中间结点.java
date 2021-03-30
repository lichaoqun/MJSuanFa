/**
 * 
 */
package 链表;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class _876_链表的中间结点 {
	
    public ListNode middleNode(ListNode head) {
    	ListNode slowListNode = head;
    	ListNode fastListNode = head;
    	while(fastListNode != null && fastListNode.next != null) {
    		slowListNode = slowListNode.next;
    		fastListNode = fastListNode.next.next;
    	}
    	return slowListNode;
     }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		_876_链表的中间结点 s = new _876_链表的中间结点();
		
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
//    	l6.next = l7;
    	System.out.println(l1);
    	System.out.println(s.middleNode(l1));
	}

}
