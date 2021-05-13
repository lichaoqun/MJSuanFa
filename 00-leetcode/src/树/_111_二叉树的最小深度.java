/**
 * 
 */
package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class _111_二叉树的最小深度 {

	// - 当遍历到第一个叶子节点时候, 就是最小的高度;
	public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
		Queue<TreeNode>queue = new LinkedList<>();
		queue.offer(root);
		int hei = 0;
		int size = queue.size();
		while (!queue.isEmpty()) {
			size--;
			TreeNode node = queue.poll();
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			
			// - 遍历到第一个叶子节点, 高度增加, 直接返回最小高度
			if (node.left == null && node.right == null) {
                hei++;
				return hei;
			}

			// - 遍历完当前的层
			if (size == 0) {
				hei++;
				size = queue.size();
			}
			
		}
		return hei;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
