/**
 * 
 */
package 链表;

import java.util.ArrayList;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 */
public class _面试题_02_01_移除重复节点 {
    public ListNode removeDuplicateNodes(ListNode head) {
    	ArrayList <Integer> nodesArrayList = new ArrayList<>();
    	ListNode virtualHeadListNode = new ListNode(0);
    	ListNode lastNode = virtualHeadListNode;
    	while (head != null) {
			if (!nodesArrayList.contains(head.val)) {
				lastNode.next = head;
				lastNode = head;
			}else {
				lastNode.next = null;
			}
			nodesArrayList.add(head.val);
			head = head.next;
		}
    	return virtualHeadListNode.next;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_面试题_02_01_移除重复节点 s = new _面试题_02_01_移除重复节点();

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
    	
		System.out.println("origin " + l1);
		System.out.println("result " + s.removeDuplicateNodes(l1));
	}

}
