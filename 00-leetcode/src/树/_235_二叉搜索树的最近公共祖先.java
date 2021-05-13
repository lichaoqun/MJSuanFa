/**
 * 
 */
package 树;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class _235_二叉搜索树的最近公共祖先 {

	// - 利用二叉搜索树的性质, 最近公共祖先某个节点( MAX(p.val, q.val)> 最近公共祖先节点 node.val > MIN(p.val, q.val));
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lowestCommonAncestorNode = root;
        while (lowestCommonAncestorNode != null) {
			if (p.val > lowestCommonAncestorNode.val && q.val > lowestCommonAncestorNode.val) {
				lowestCommonAncestorNode = lowestCommonAncestorNode.right;
			}else if (p.val < lowestCommonAncestorNode.val && q.val < lowestCommonAncestorNode.val) {
				lowestCommonAncestorNode = lowestCommonAncestorNode.left;
			}else {
				return lowestCommonAncestorNode;
			}
		}
        return lowestCommonAncestorNode;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
