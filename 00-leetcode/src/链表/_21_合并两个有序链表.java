/**
 * 
 */
package 链表;

/**
 * @author QG
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class _21_合并两个有序链表 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode last = head;
		while (l1.next != null && l2.next != null) {
			if(l1.val > l2.val) {
                last.next = l2;
                l2 = l2.next;
            }else{
                last.next = l1;
                l1 = l1.next;
            }
			last = last.next;
		}
		
		if(l1 != null) last.next = l1;
		if(l2 != null) last.next = l2;
		return head.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_21_合并两个有序链表 s = new _21_合并两个有序链表();

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

    	ListNode l11 = new ListNode(1);
    	ListNode l22 = new ListNode(3);
    	ListNode l33 = new ListNode(5);
    	ListNode l44 = new ListNode(7);
    	ListNode l55 = new ListNode(9);
    	ListNode l66 = new ListNode(11);
    	ListNode l77 = new ListNode(12);
    	ListNode l88 = new ListNode(13);
    	l11.next = l22;
    	l22.next = l33;
    	l33.next = l44;
    	l44.next = l55;
    	l55.next = l66;
    	l66.next = l77;
    	l77.next = l88;
    	
    	System.out.println(s.mergeTwoLists(l1, l11));

	}

}
