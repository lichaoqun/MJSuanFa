/**
 * 
 */
package 栈;

import java.util.Stack;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/baseball-game/
 */
public class _682_棒球比赛 {
	public int calPoints(String[] ops) {
		Stack<Integer>stack = new Stack<>();
		int result = 0;
		for (int i = 0; i < ops.length; i++) {
			String string = ops[i];
			if (string.equals("C")){
				int val = stack.pop();
				result -= val;
			}else if (string.equals("D")){
				int prev_1 = stack.peek();
				int val = prev_1 * 2;
				stack.push(val);
				result += val;
			}else if(string.equals("+")) {
				int prev_1 = stack.pop();
				int prev_2 = stack.peek();
				int val = prev_1 + prev_2;
				stack.push(prev_1);
				stack.push(val);
				result += val;
			}else {
				int val = Integer.valueOf(string);
				stack.push(val);
				result += val;
			}
		}
		return result;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_682_棒球比赛 s = new _682_棒球比赛();
		String[] ops1 = {"5","2","C","D","+"};
		System.out.println(s.calPoints(ops1));

		String[] ops2 = {"5","-2","4","C","D","9","+","+"};
		System.out.println(s.calPoints(ops2));

		String[] ops3 = {"1"};
		System.out.println(s.calPoints(ops3));
	}

}
