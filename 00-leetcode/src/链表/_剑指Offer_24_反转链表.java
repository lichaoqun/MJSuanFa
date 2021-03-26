/**
 * 
 */
package 链表;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class _剑指Offer_24_反转链表 {
    public ListNode reverseList(ListNode head) {
    	ListNode last = null;
    	while (head != null) {
			ListNode temp = head.next;
			head.next = last;
			last = head;
			head = temp;
		}
    	return last;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_剑指Offer_24_反转链表 s = new _剑指Offer_24_反转链表();

    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(4);
    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = null;
    	
		System.out.println(l1);
		System.out.println(s.reverseList(l1));
	}

}
