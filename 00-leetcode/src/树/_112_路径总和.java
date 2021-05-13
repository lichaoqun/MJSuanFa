/**
 * 
 */
package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/path-sum/
 */
public class _112_路径总和 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
    	if (root == null) return false;
    	
    	Queue<TreeNode>nodeQ = new LinkedList<>();
    	Queue<Integer>nodeV = new LinkedList<>();
    	nodeQ.offer(root);
    	nodeV.offer(root.val);
    	
    	while (!nodeQ.isEmpty()) {
			TreeNode node = nodeQ.poll();
			int val = nodeV.poll();
			
			// - 叶子节点的路径总和 == targetSum
			if (node.left == null && node.right == null && val == targetSum) {
				return true;
			}
			
			// - 层序遍历每个叶子节点并保存每个叶子节点的路径总和
			if (node.left != null) {
				nodeQ.offer(node.left);
				nodeV.offer(node.left.val + val);
			}
			if (node.right != null) {
				nodeQ.offer(node.right);
				nodeV.offer(node.right.val + val);
			}
		}
    	
    	return false;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
