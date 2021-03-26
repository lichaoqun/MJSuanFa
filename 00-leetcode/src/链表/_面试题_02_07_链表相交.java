/**
 * 
 */
package 链表;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 */
public class _面试题_02_07_链表相交 {
	
	//  - 
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        
        while (pA != null && pB != null) {
			if (pA == pB) return pA;
			pA = (pA.next == null) ? pB : pA.next;
			pB = (pB.next == null) ? pA : pB.next;
		}
        return null;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
