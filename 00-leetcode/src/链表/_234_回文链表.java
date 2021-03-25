/**
 * 
 */
package 链表;

/**
 * @author lichaoqun
 *	https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class _234_回文链表 {
	
    public boolean isPalindrome(ListNode head) {
    	ListNode lastNode = null;
    	ListNode newHead = null;
    	ListNode oriHead = head;

    	// - 复制链表
    	while (head != null) {
        	ListNode node = new ListNode(head.val);
        	if (lastNode != null) {
				lastNode.next = node;
				lastNode = node;
			}else {
				newHead = lastNode = node;
			}
        	head = head.next;
		}
 
				
    	// - 翻转
    	head = oriHead;
    	lastNode = null;
    	while (head != null) {
			ListNode temp = head.next;
			head.next = lastNode;
			lastNode = head;
			head = temp;
		}
    	
    	// - 对比
    	oriHead = lastNode;
    	System.out.println(oriHead);
    	System.out.println(newHead);
    	while (newHead != null) {
    		System.out.println(newHead.val + "==" + oriHead.val);
    		if (newHead.val != oriHead.val) return false;
    		newHead = newHead.next;
    		oriHead = oriHead.next;
		}

    	return true;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_234_回文链表 s = new _234_回文链表();

		ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(3);
    	ListNode l5 = new ListNode(2);
    	ListNode l6 = new ListNode(1);
    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;
    	l5.next = l6;
    	System.out.println(s.isPalindrome(l1));
	}

}
