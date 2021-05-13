/**
 * 
 */
package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class _404_左叶子之和 {
	
	// - 层序遍历每个节点, 
	public int sumOfLeftLeaves(TreeNode root) {
		Queue<TreeNode>queue = new LinkedList<>();
		int sum = 0;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode curNode = queue.poll();
			
			if (curNode.left != null) {
				queue.offer(curNode.left);
				
				if (curNode.left.left == null && curNode.left.right == null) {
					sum += curNode.left.val;
				}
			}

			if (curNode.right != null) {
				queue.offer(curNode.right);
			}
		}
		return sum;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
