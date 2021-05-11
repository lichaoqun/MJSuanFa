/**
 * 
 */
package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class _101_对称二叉树 {
	public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
    
    public boolean isSymmetric1(TreeNode root) {
        return check(root, root);
    }

    // - 将镜像的点 存储在队列中相邻的位置上;
    public boolean check1(TreeNode u, TreeNode v) {
    	// - 保存节点
    	Queue<TreeNode>q = new LinkedList<TreeNode>();
    	q.offer(u);
    	q.offer(v);
    	
    	// - 遍历每个节点
    	while (!q.isEmpty()) {
			u = q.poll();
			v = q.poll();
			
			// - 如果取出的两个连续的节点都是空的, 则跳过比较逻辑
			if(u == null && v == null) continue;
			
			// - 如果只有一个是空的, 或者值不同, 代表节点不同
			if (u == null || v == null || u.val != v.val) return false;
			
			// - 将(值相同)镜像的两个节点 入队
			q.offer(u.left);
			q.offer(v.right);
			q.offer(u.right);
			q.offer(v.left);
		}
        return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
