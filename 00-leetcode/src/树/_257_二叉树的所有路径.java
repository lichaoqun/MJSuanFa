/**
 * 
 */
package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class _257_二叉树的所有路径 {
	
	// - 层序遍历二叉树, 同时使用另个队列存储按照存储每个节点的路径
	public List<String> binaryTreePaths(TreeNode root) {
		List<String>list = new ArrayList();
		Queue<TreeNode>queue = new LinkedList<>();
		Queue<String>pathQueue = new LinkedList<>();
		queue.offer(root);
		pathQueue.offer(root.val + "");
		
		while (!queue.isEmpty()) {
			TreeNode curNode = queue.poll();
			String path = pathQueue.poll();
			if (curNode.left != null) {
				queue.offer(curNode.left);
				pathQueue.offer(path + "->" + curNode.left.val);
			}
			if (curNode.right != null) {
				queue.offer(curNode.right);
				pathQueue.offer(path + "->" + curNode.right.val);
			}
			
			
			// - 叶子节点
			if (curNode.left == null && curNode.right == null) {
				list.add(path);
			}
		}
		
		
		
//		Stack<TreeNode>stack = new Stack<>();
//		TreeNode curNode = root;
//		// - 先序遍历二叉树
//		while (true) {
//			if (curNode != null) {
//				stack.push(curNode);
//				curNode = curNode.left;
//			}else {
//				if (stack.isEmpty()) return list;
//				TreeNode node = stack.pop();
//				StringBuilder pathString = pathStack.pop();
//				curNode = node.right;
//			}
//		}
		
//		// - 后序遍历二叉树
//		Stack<TreeNode>stack = new Stack<>();
//		TreeNode lastTreeNode = root;
//		stack.push(root);
//		while (!stack.isEmpty()) {
//			TreeNode curNode = stack.peek();
//			if ((curNode.left == null && curNode.right == null) || lastTreeNode == curNode.left || lastTreeNode == curNode.right) {
//				System.out.println(curNode.val);
//				stack.pop();
//				lastTreeNode = curNode;
//			}else {
//				if(curNode.right != null) stack.push(curNode.right);
//				if(curNode.left != null) stack.push(curNode.left);
//			}
//		}		
		return list;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

