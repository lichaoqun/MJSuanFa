/**
 * 
 */
package 栈;

import java.util.Stack;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/make-the-string-great/
 */
public class _1544_整理字符串 {
	
	public String makeGood(String s) {
		Stack<Character>stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!stack.isEmpty() && (((ch + 32) == stack.peek()) || (ch - 32) == stack.peek())) {
				stack.pop();
			}else {
				stack.push(ch);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop());
		}
		return sb.toString();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		_1544_整理字符串 s = new _1544_整理字符串();
		System.out.println(s.makeGood("leEeetcode"));
		System.out.println(s.makeGood("abBAcC"));
		System.out.println(s.makeGood("s"));
	}

}
