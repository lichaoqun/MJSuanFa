/**
 * 
 */
package 链表;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 */
public class _面试题_02_07_链表相交 {
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
			pA = (pA == null) ? headB : pA.next;
			pB = (pB == null) ? headA : pB.next;
		}
        return pA;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_面试题_02_07_链表相交 s = new _面试题_02_07_链表相交();
		
		ListNode l1 = new ListNode(0);
    	ListNode l2 = new ListNode(9);
    	ListNode l3 = new ListNode(1);
    	ListNode l4 = new ListNode(2);
    	ListNode l5 = new ListNode(4);
    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;
    	l5.next = null;
    	System.out.println(l1);

    	ListNode l11 = new ListNode(3);
    	l11.next = l4;
    	System.out.println(l11);
    	
    	System.out.println(s.getIntersectionNode(l1, l11));
	}

}
