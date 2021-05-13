/**
 * 
 */
package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class _145_二叉树的后序遍历 {
	
	public List<Integer> postorderTraversal(TreeNode root) {
		
		// - 空判断
        List<Integer> list = new ArrayList<>();
		if (root == null) return list;
		
		// - 后续遍历
    	Stack<TreeNode>stack = new Stack<>();
    	stack.push(root);
    	TreeNode lastNode = root;
    	
        while(!stack.isEmpty()) {
        	TreeNode curNode = stack.peek();
        	// - 当前的节点是叶子节点, 或者当前节点的子树被访问过
        	if ((curNode.left == null && curNode.right == null) || curNode.left == lastNode || curNode.right == lastNode) {
        		list.add(curNode.val);
        		stack.pop();
        		lastNode = curNode;
        		System.out.println(curNode.val);
			}else {
				if (curNode.right != null) stack.push(curNode.right);
				if (curNode.left != null) stack.push(curNode.left);
			}
        }
        return list; 
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
