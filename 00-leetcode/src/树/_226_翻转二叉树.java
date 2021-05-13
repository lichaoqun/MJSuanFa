/**
 * 
 */
package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class _226_翻转二叉树 {
	public TreeNode invertTree(TreeNode root) {
		
		// - 空判断
		if(root == null) return null;

		// - 层序遍历
		Queue<TreeNode>queue = new LinkedList<>();
		queue.offer(root);
		int size = queue.size();
		while (!queue.isEmpty()) {
			TreeNode curNode = queue.poll();
			size--;
			if (curNode.left != null) queue.offer(curNode.left);
			if (curNode.right != null) queue.offer(curNode.right);
			
			// - 翻转当前节点的左右子树
			TreeNode tempNode = curNode.left;
			curNode.left = curNode.right;
			curNode.right = tempNode;
		}
		
		return root;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
