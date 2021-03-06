package 链表;

public class _0_思路 {
	/*
	 * 1. 翻转链表: 使用递归和迭代都可以遍历和翻转链表(递归函数调用的位置之后的代码的执行顺序是先执行后传入的参数, 在执行先传入的参数的, 迭代是按序的)
	 *  	递归的停止条件 决定了递归能传入的最有一个节点
	 *  	while的循环判断条件 决定了节点的最后一个next
	 *  
	 *  2. 相交链表的相交节点: 使用双指针法, A链表的节点个数 + B链表相交节点前的节点的个数 == B链表的节点个数 + A链表相交节点前的节点的个数
	 *  = 遍历到两个链表相交所需走的步数;
	 *  
	 *  3. 判断一个链表是否有环: 快慢指针(快的走两部, 慢的走一步), 如果一个链表有环, 那么两个指针一定会相遇
	 *  
	 *  4. 链表的中间节点: 快慢指针(快的走两部, 慢的走一步), 当快的走到终点时候, 慢指针所在的位置就是中点;
	 *  
	 *  5. 回文链表: 查找中间节点的同时翻转前部分链表, 然后遍历前部分链表和后部分链表的每个值是否相等;(如果是1->2->3->2->1格式的链表, 后部分链表应该是从2->1,而不是3->2->1, 需要去next)
	 *  也可以使用栈的思维做这个
	 *  
	 *  6. 返回倒数第K个节点: 使用双指针, 先让两个指针相距K, 然后同时移动两个指针, 当较快的指针为空时候, 较慢的指针就是倒数第K个节点;
	 *  
	 *  7. 二进制链表转十进制链表: 遍历, result = (resule << 2) + node.val; 十进制转二进制 :计算方式相反;  
	 *  
	 * */
	
	
	// - 链表的遍历
	public ListNode node(ListNode head) {

		/** 迭代 10111
		  	while (head != null) {
				System.out.println(head);
				head = head.next;
			}
			return null;
		
		 * 	1->0->1->1->1->null
			0->1->1->1->null
			1->1->1->null
			1->1->null
			1->null 
		 * */
		
		
		/** 迭代 10111
			while (head.next != null) {
				System.out.println(head);
				head = head.next;
			}
			return null;
			
		 * 	1->0->1->1->1->null
			0->1->1->1->null
			1->1->1->null
			1->1->null
		 * */
		
		
		/** 递归 10111  
			if (head == null) return head;
			ListNode last = node(head.next);
			System.out.println("head: " + head + ", last:" + last);
			return head;

		 * 	head: 1->null, last:null
			head: 1->1->null, last:1->null
			head: 1->1->1->null, last:1->1->null
			head: 0->1->1->1->null, last:1->1->1->null
			head: 1->0->1->1->1->null, last:0->1->1->1->null
		 * */
		

		/** 递归 10111
			if (head.next == null) return head;	
			ListNode last = node(head.next);
			System.out.println("head: " + head + ", last:" + last);
			return head;	
			
		 * 	head: 1->1->null, last:1->null
			head: 1->1->1->null, last:1->1->null
			head: 0->1->1->1->null, last:1->1->1->null
			head: 1->0->1->1->1->null, last:0->1->1->1->null
		 * */
		return null;
	}
}
