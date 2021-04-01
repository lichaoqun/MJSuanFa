/**
 * 
 */
package 栈;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/next-greater-element-i/
 */
public class _496_下一个更大元素一 {
	 public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	    	java.util.Stack<Integer>stack = new java.util.Stack<>();
	    	// - 入栈
	    	for (int i = 0; i < nums1.length; i++) {
				stack.push(nums1[i]);
			}
	    	
	    	java.util.Stack<Integer>valStack = new java.util.Stack<>();
	    	while (!stack.isEmpty()) {
	    		int val = 0;
				int stackVal = stack.peek();

				for (int i = 0; i < nums2.length; i++) {
					int curVal = nums2[i];
					if (curVal == stackVal) {
						stack.pop();
						val = -1;
					}else if (val == -1 && curVal > stackVal) {
						
						val = curVal;
						i = nums2.length - 1;
					}
					
					if ( i == nums2.length - 1) {
						valStack.push(val);
					}
				}
			}
	    	
	    	
	    	int[] valus = new int[valStack.size()];
	    	for (int i = 0; i < valus.length; i++) {
	    		valus[i] = valStack.pop();
			}
	    	
	    	return valus;
	    }
	    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_496_下一个更大元素一 s = new _496_下一个更大元素一();
		int[] num1 = {4,1,2};
		int[] num2 = {1,3,4,2};
		int[] vals = s.nextGreaterElement(num1, num2);
		for (int i = 0; i < 3; i++) {
			System.out.println(vals[i]);			
		}

	}

}
