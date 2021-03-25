/**
 * 
 */
package 链表;

/**
 * @author QG
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class _160_相交链表 {

	/**
	 * @param args
	 */

	// - 垃圾方法
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
    	// - 翻转链表A和B
    	ListNode listALastNode = null;
    	while (headA != null) {
    		ListNode temp = headA.next;
			headA.next = listALastNode;
			listALastNode = headA;
			headA = temp;
		}
    	System.out.println(listALastNode);
    	
    	ListNode listBLastNode = null;
    	while (headB != null) {
    		ListNode temp = headB.next;
			headB.next = listBLastNode;
			listBLastNode = headB;
			headB = temp;
		}
    	System.out.println(listBLastNode);
    	
    	// - 循环遍历, 当出现不同的时候, 就是两个链表相交的时候
    	ListNode lastNode = null;
    	ListNode newHead = null;
    	while (listALastNode != null && listALastNode != null) {
    		if (listALastNode.val != listBLastNode.val) {
				break;
			}
    		ListNode tempA = listALastNode.next;
    		ListNode tempB = listBLastNode.next;
    		if (lastNode == null) {
    			lastNode = listALastNode;
    			newHead = lastNode;
			}else {
	    		lastNode.next = listALastNode;
	    		lastNode = listALastNode;
			}
    		listALastNode = tempA;
    		listBLastNode = tempB;
		}
    	
    	System.out.println(newHead);
    	ListNode tlastNode = null;
    	while (newHead != null) {
    		ListNode temp = newHead.next;
    		newHead.next = tlastNode;
    		tlastNode = newHead;
			newHead = temp;
		}
    	if (tlastNode == null) return null;
        return tlastNode.next;
    }
    
	// - 高级方法
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
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		_160_相交链表 s = new _160_相交链表();
		
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
    	System.out.println(l1);

    	ListNode l11 = new ListNode(7);
    	ListNode l22 = new ListNode(6);
    	ListNode l33 = new ListNode(5);
    	ListNode l44 = new ListNode(4);
    	ListNode l55 = new ListNode(3);
    	ListNode l66 = new ListNode(2);
    	ListNode l77 = new ListNode(1);
    	ListNode l88 = new ListNode(0);
    	l11.next = l22;
    	l22.next = l33;
    	l33.next = l44;
    	l44.next = l55;
    	l55.next = l66;
    	l66.next = l77;
    	l77.next = l88;
    	System.out.println(l11);
    	
    	
    	System.out.println(s.getIntersectionNode(l1, l11));
	}

}
