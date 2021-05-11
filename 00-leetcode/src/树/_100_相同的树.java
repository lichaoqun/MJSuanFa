/**
 * 
 */
package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/same-tree/
 */
public class _100_相同的树 {
	
	// - 递归的方式
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		if (p.val != q.val) return false;
		return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
	
	// - 层序遍历的方式
	public boolean isSameTree1(TreeNode p, TreeNode q) {
		// - 判断根节点是不是为null
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		
		// - 根节点不为null
		Queue<TreeNode>p1 = new LinkedList<TreeNode>();
		p1.offer(p);
		Queue<TreeNode>q1 = new LinkedList<TreeNode>();
		q1.offer(q);
		
		while (!p1.isEmpty() && !q1.isEmpty()) {
			// - 当前遍历到的元素
			TreeNode pNode = p1.poll();
            TreeNode qNode = q1.poll();
            
            // - 每个元素的左右子树
			TreeNode pLeft = pNode.left;
			TreeNode qLeft = qNode.left;
			TreeNode pRight = pNode.right;
			TreeNode qRight = qNode.right;
			
			// - 如果节点的两个左子树或右子树不同时为null, 则表示树不同;
			if(((pLeft == null) ^ (qLeft == null))) return false;
			if(((pRight == null) ^ (qRight == null))) return false;
			
			// - 节点的值不同
			if(pNode.val != qNode.val) return false;
			
			// - 继续层序遍历
			if (pLeft != null) p1.offer(pLeft);
			if (pRight != null) p1.offer(pRight);
			if (qLeft != null) q1.offer(qLeft);
			if (qRight != null) q1.offer(qRight);
		}
		
		// - 当有任意一个链表遍历完成时候, 需要比较两个链表是不是都遍历完成了;
		return (p1.isEmpty() && q1.isEmpty());
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_100_相同的树 s = new _100_相同的树();
		boolean result = s.isSameTree(null, null);
		System.out.println(result);
	}

}