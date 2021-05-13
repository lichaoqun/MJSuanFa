/**
 * 
 */
package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */
public class _501_二叉搜索树中的众数 {


    public int[] findMode(TreeNode root) {
    	// - 中序遍历(中序遍历搜索二叉树的结果是 按顺序的)
    	List<Integer> answer = new ArrayList<Integer>();
        Stack<TreeNode>stack = new Stack<>();
        TreeNode curNode = root;
        while (true) {
			if (curNode != null) {
				stack.push(curNode);
				curNode = curNode.left;
			}else {
				if (stack.isEmpty()) break;
		        TreeNode node = stack.pop();
		        answer.add(node.val);
		        curNode = node.right;
			}
		}
        
        // - 保存众数
        int maxCount = 0;
        int count = 0;
        int lastVal = 0;
    	List<Integer> resultArray = new ArrayList<Integer>();
        for (int i = 0; i < answer.size(); i++) {
        	
        	// - 遍历到每个元素
        	int val = answer.get(i);
        	
        	// - 记录上次访问到过的数字和对应的数字的出现的次数
        	if (lastVal == val) {
				count++;
			}else{
				count = 1;
				lastVal = val;
			}
        	
        	// - 当前访问的数字的数量 < 之前记录的访问过的数字的最大数量
        	if(count < maxCount) continue;
        	
        	// - 出现的次数和当前记录过的最大次数作对比
        	if (count> maxCount) {
				resultArray.clear();
			}	
        	maxCount = count;
    		resultArray.add(val);
		}
        
        int[] mode = new int[resultArray.size()];
        for (int i = 0; i < resultArray.size(); ++i) {   
            mode[i] = resultArray.get(i);
        }
    	
    	return mode;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
