package 链表;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(this.val).append("->");
		if (this.next != null) {
			sb.append(this.next);
		}else {
			sb.append("null");
		}
		return sb.toString();
	}
}
