/**
 * 
 */
package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class _530_二叉搜索树的最小绝对差 {

	// - 中序遍历按顺序排列, 寻找相邻两个的差最小的树
	public int getMinimumDifference(TreeNode root) {
		
		// - 保存中序遍历的结果
		List<Integer> list = new ArrayList<>();
		
		// - 中序遍历
		Stack<TreeNode>stack = new Stack<>();
		TreeNode curNode = root;
		while (true) {
			if (curNode != null) {
				stack.push(curNode);
				curNode = curNode.left;
			}else {
				if(stack.isEmpty()) break;
				TreeNode tempNode = stack.pop();
				list.add(tempNode.val);
				curNode = tempNode.right;
			}
		}
		Integer lastVal = -1;
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			Integer curValInteger = list.get(i);
			if (lastVal >= 0) {
				minDiff = Math.min(minDiff, Math.abs(curValInteger - lastVal));
			}
			lastVal = curValInteger;	
		}
		return minDiff;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
