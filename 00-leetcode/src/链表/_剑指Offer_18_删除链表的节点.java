/**
 * 
 */
package 链表;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class _剑指Offer_18_删除链表的节点 {
	public ListNode deleteNode(ListNode head, int val) {
		ListNode virtualHead = new ListNode(0);
		ListNode lastNode = virtualHead;
		while (head != null) {
			if (head.val != val) {
				lastNode.next = head;
				lastNode = head;
			}else {
				lastNode.next = null;
			}
			head = head.next;
		}
		return virtualHead.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_剑指Offer_18_删除链表的节点 s = new _剑指Offer_18_删除链表的节点();

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
    	System.out.println(s.deleteNode(l1, 5));
	}

}
