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
	// - 双指针
	 public int kthToLast1(ListNode head, int k) {
	        ListNode dummyHead = new ListNode(-1);
	        dummyHead.next = head;
	        ListNode p = dummyHead;
	        ListNode q = dummyHead;
	        for (int i = 0; i < k; i++) {
	            q = q.next;
	        }
	        while (q!=null) {
	            q = q.next;
	            p = p.next;
	        }
	        return p.val;
	   }
	 
	 public int kthToLast2(ListNode head, int k) {
	        ListNode p = head;
	        ListNode q = head;
	        for (int i = 0; q != null; i++) {
	        	// - 以下两种写法都可以
//	             q = q.next;
//	             if(i < k)continue;
//	             p = p.next;
	        	
	        	 q = q.next;
	             if(i >= k) {;
	             	p = p.next;
	             }
	        }
	        return p.val;
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
    	System.out.println(s.kthToLast2(l1, 1));
	}

}
