/**
 * 
 */
package 栈;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/build-an-array-with-stack-operations/
 */
public class _1441_用栈操作构建数组 {
	public List<String> buildArray(int[] target, int n) {
		Stack<Integer>stack = new Stack<>(); 
		while (n > 0) {
			stack.push(n);
			n--;
		}
		
		List<String> arrayList = new ArrayList<>();
		int i = 0;
		while (i < target.length) {
			int val = stack.pop();
			arrayList.add("Push");
			if (target[i] != val) {
				arrayList.add("Pop");
				continue;
			}
			i++;
		}
		
		return arrayList;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
