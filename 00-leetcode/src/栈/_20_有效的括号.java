/**
 * 
 */
package 栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20_有效的括号 {

	public boolean isValid(String s) {
		HashMap<Character, Character> maps = new HashMap<>();
		Stack<Character> stack = new Stack<>();
		maps.put('(', ')');
		maps.put('{', '}');
		maps.put('[', ']');
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (maps.containsKey(ch)) { 
				stack.push(ch);
			}else if (maps.containsValue(ch)) {
				if (stack.isEmpty()) return false;
				if (ch != maps.get(stack.pop())) return  false;
			}
		}
		return stack.isEmpty();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_20_有效的括号 s = new _20_有效的括号();
		
		System.out.println(s.isValid("(({[({})]}))"));
	}

}
