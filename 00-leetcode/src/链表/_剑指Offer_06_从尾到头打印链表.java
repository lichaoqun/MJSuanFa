/**
 * 
 */
package 链表;

import java.util.ArrayList;
/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class _剑指Offer_06_从尾到头打印链表 {

    public int[] reversePrint(ListNode head) {
    	ArrayList <ListNode> nodeArray = reverseNodeArray(head);
    	int[] result = new int[nodeArray.size()];
    	if (nodeArray.size() == 0) return result;
    	System.err.println(nodeArray.size());
    	for (int i = 0; i < nodeArray.size(); i++) {
    		result[i] = nodeArray.get(i).val;
		}
    	return result;
    }

    public ArrayList<ListNode> reverseNodeArray(ListNode head) {
    	if (head == null || head.next == null) {
        	ArrayList <ListNode> arrayList = new ArrayList<>();
        	if (head != null) {
        		arrayList.add(head);
        	}
    		return arrayList;
    	}
    	
    	ArrayList <ListNode> nodeArray = new ArrayList<>();
    	ArrayList <ListNode> resultArray = reverseNodeArray(head.next);
    	for (int i = 0; i < resultArray.size(); i++) {
    		nodeArray.add(resultArray.get(i));
		}
    	nodeArray.add(head);
    	return nodeArray;

    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		_剑指Offer_06_从尾到头打印链表 s = new _剑指Offer_06_从尾到头打印链表();

    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(4);
    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = null;
    	
    	int[] result = s.reversePrint(null);
    	for (int i = 0; i < result.length; i++) {
    		System.out.println(result[i]);			
		}

	}

}
