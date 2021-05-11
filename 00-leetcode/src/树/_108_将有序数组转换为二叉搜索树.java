/**
 * 
 */
package 树;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class _108_将有序数组转换为二叉搜索树 {

	
	
	
	
	
	
	
	
	// - 无序数组生成二叉搜索树(非平衡)
	public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        TreeNode rooTreeNode = new TreeNode(nums[0]);
        for (int i = 1; i < len; i++) {
        	TreeNode curNode = new TreeNode(nums[i]);
			addNode(rooTreeNode, curNode.val);
		}
        return rooTreeNode;
    }
	
	public int compare(int i1, int i2) {
		return (i2 - i1);
	}
	
	public void addNode(TreeNode rooTreeNode, int val) {
		TreeNode node = rooTreeNode;
		TreeNode parentNode = null;
		int compareResult = 0;
		while (node != null) {
			parentNode = node;
			compareResult =  compare(rooTreeNode.val, val);
			if (compareResult == 0) {
				node.val = val;
				return;
			}
			node =  (compareResult > 0) ? node.right : node.left;
		}
		node = new TreeNode(val);
		if (compareResult >0) {
			parentNode.right = node;
			return;
		}
		parentNode.right = node;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
