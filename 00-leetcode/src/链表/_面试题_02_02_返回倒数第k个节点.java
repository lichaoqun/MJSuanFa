/**
 * 
 */
package 链表;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 */
public class _面试题_02_02_返回倒数第k个节点 {
	private int count = 0;
	private ListNode newNode = null;
    public int kthToLast(ListNode head, int k) {
        return kthToLastNode(head, k).val;
    }
    
	public ListNode kthToLastNode(ListNode head, int k) {
		if (head == null) return null; 
		ListNode node = kthToLastNode(head.next, k);
		if (count == k) {
			newNode = node;
		}
		count++;
		return (newNode != null) ? newNode : head;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_面试题_02_02_返回倒数第k个节点 s = new _面试题_02_02_返回倒数第k个节点();

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
    	System.out.println(s.kthToLast(l1, 1));
	}

}
