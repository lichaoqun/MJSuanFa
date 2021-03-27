/**
 * 
 */
package 链表;

/**
 * @author lichaoqun
 *	https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class _234_回文链表 {
	
	// - 笨方法
    public boolean isPalindrome(ListNode head) {
    	ListNode newHead = new ListNode(0);
    	ListNode lastNode = newHead;
    	ListNode oriHead = head;

    	// - 复制链表
    	while (head != null) {
        	ListNode node = new ListNode(head.val);
			lastNode.next = node;
			lastNode = node;
        	head = head.next;
		}
    	newHead = newHead.next;
    	System.out.println("newHead : " + newHead);
				
    	// - 翻转链表
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
    
    // - 取巧的方法
    public boolean isPalindrome1(ListNode head) {
    	
    	// - 1. 获取链表的中间节点同时翻转前半部分链表
    	// - 快慢指针 用来定位到链表的中间节点
    	ListNode slowListNode = head;
    	ListNode fastListNode = head;
    	
    	// - 记录上一个被遍历大的节点, 用来翻转链表
    	ListNode lastNode = null;
    	
    	// - 保存前半部分链表和后半部分链表
    	ListNode beforeHalfList = null;
    	ListNode aferHalfList = null;
    	
    	// - 查找链表的中间节点并且翻转
    	while (fastListNode != null && fastListNode.next != null) {
    		// - 记录当前快慢指针的的下一个元素, 防止翻转链表时候, 值被覆盖
    		ListNode tempSlowListNode = slowListNode.next;
    		ListNode tempFastListNode = fastListNode.next.next;
    		
    		// - 翻转链表
    		slowListNode.next = lastNode;
    		lastNode = slowListNode;
    		
    		// - 保存前半部分链表的头结点
    		beforeHalfList = lastNode;
    		
    		// - 快慢指针前进
			slowListNode = tempSlowListNode;
			fastListNode = tempFastListNode;
			
			// - 保存后半部分链表的头结点(如果已经遍历到链表的尾结点, 并且链表长度为奇数, 应该将头结点的位置向后移动 (1->2->1) 也是回文链表)
			aferHalfList = slowListNode;
			if (fastListNode != null && fastListNode.next == null) {
				aferHalfList = aferHalfList.next;
			}
		}    	
    	
    	System.out.println("before: " + beforeHalfList + ", after: " + aferHalfList);
    	
    	// - 2. 循环对比每个元素;
    	while (beforeHalfList != null) {
			if (beforeHalfList.val != aferHalfList.val) return false;
			beforeHalfList = beforeHalfList.next;
			aferHalfList = aferHalfList.next;
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
    	ListNode l3 = new ListNode(2);
    	ListNode l4 = new ListNode(1);
    	ListNode l5 = new ListNode(2);
    	ListNode l6 = new ListNode(1);
    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
//    	l4.next = l5;
//    	l5.next = l6;
    	System.out.println(s.isPalindrome1(l1));
//    	System.out.println(s.isPalindrome(l1));
	}

}
