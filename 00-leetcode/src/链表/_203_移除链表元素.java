package 链表;
/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/submissions/ 
 */
public class _203_移除链表元素 {

	// - 迭代方法移除链表元素使用虚拟头结点
    public ListNode removeElements(ListNode head, int val) {    	
    	ListNode newHead = new ListNode(0);
    	ListNode lastNode = newHead;
    	while (head != null) {
    		lastNode.next = null;
    		if (head.val != val) {
    			lastNode.next = head;
    			lastNode = lastNode.next;
			}
    		head = head.next;
		}
    	return newHead.next;
    }

    // - 递归方法移除链表元素
    public ListNode removeElements1(ListNode head, int val) {
    	ListNode node = recursiveGetHead(head, val);
    	if (node != null && node.val == val) return node.next;
    	return node;
    }
    public ListNode recursiveGetHead(ListNode head, int val) {
    	if (head == null || head.next == null) return head;
    	ListNode node = recursiveGetHead(head.next, val);
    	if (node.val == val) {
			head.next = node.next;
		}
    	return head;
    }
    
    // - 递归方式
    public ListNode removeElements2(ListNode head, int val) {
    	if (head == null) return null;
    	head.next = removeElements2(head.next, val);
    	if(head.val==val){
            return head.next;
        }else{
            return head;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	_203_移除链表元素 s = new _203_移除链表元素();

		ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(6);
    	ListNode l4 = new ListNode(3);
    	ListNode l5 = new ListNode(4);
    	ListNode l6 = new ListNode(5);
    	ListNode l7 = new ListNode(6);
    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;
    	l5.next = l6;
    	l6.next = l7;
    	l7.next = null;
    	System.out.println(l1);
    	ListNode lx = s.removeElements(l1, 6);
    	System.out.println(lx);
    	
    	
		ListNode l11 = new ListNode(7);
    	ListNode l22 = new ListNode(7);
    	ListNode l33 = new ListNode(7);
    	ListNode l44 = new ListNode(7);
    	l11.next = l22;
    	l22.next = l33;
    	l33.next = l44;
    	l44.next = null;
    	System.out.println(l11);
    	ListNode lx11 = s.removeElements(l11, 7);
    	System.out.println(lx11);

    	ListNode lx111 = s.removeElements(null, 1);
    	System.out.println(lx111);
    	

		ListNode l1111 = new ListNode(1);
		l1111.next = null;
    	System.out.println(l1111);
    	ListNode lx1111 = s.removeElements(l1111, 2);
    	System.out.println(lx1111);

		ListNode l11111 = new ListNode(1);
		ListNode l22222 = new ListNode(2);
		l11111.next = l22222;
		l22222.next = null;
    	System.out.println(l11111);
    	ListNode lx11111 = s.removeElements(l11111, 1);
    	System.out.println(lx11111);
	}
}
