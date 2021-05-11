/**
 * 
 */
package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class _104_二叉树的最大深度 {
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode>queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int height = 0;
		int size = queue.size();
		
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			size--;
			
			if (node.left != null) queue.offer(node.left);
			if (node.right != null) queue.offer(node.right);
			
			if (size == 0) {
				size = queue.size();
				height++;
			}
			
		}
		return height;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
