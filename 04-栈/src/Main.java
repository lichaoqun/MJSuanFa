import java.util.ArrayList;

import com.sun.net.httpserver.Authenticator.Result;

/**
 * @author QG
 *
 */

/* 844. 比较含退格的字符串
 * https://leetcode-cn.com/problems/backspace-string-compare/
 * */
class Solution {
    public boolean backspaceCompare(String S, String T) {
    	java.util.Stack<Character> stackS = new java.util.Stack<>();
    	for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if (ch == '#') {
				if (!stackS.isEmpty()) {
					stackS.pop();
				}
				
				continue;
			}
			stackS.push(ch);
		}
    	
    	java.util.Stack<Character> stackT = new java.util.Stack<>();
    	for (int i = 0; i < T.length(); i++) {
			char ch = T.charAt(i);
			if (ch == '#') {
				if (!stackT.isEmpty()) {
					stackT.pop();
				}
				continue;
			}
			stackT.push(ch);
		}
    	if (stackS.size() != stackT.size()) return false;
    	
    	while (!stackS.isEmpty()) {
    		System.out.println(stackS.peek() + "xx" + stackT.peek());
			if (stackS.pop() != stackT.pop()) return false;
		}
    	
        return true;
    }
    
    public boolean backspaceCompare1(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String str) {
        StringBuffer ret = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            char ch = str.charAt(i);
            if (ch != '#') {
                ret.append(ch);
            } else {
                if (ret.length() > 0) {
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }
    
    /* 1021. 删除最外层的括号
     * https://leetcode-cn.com/problems/remove-outermost-parentheses/
     * */
    public String removeOuterParentheses(String S) {
    	java.util.Stack<Character> stacks = new java.util.Stack<>();
    	StringBuilder stringBuilder = new StringBuilder();
    	StringBuilder resultString = new StringBuilder();
    	for (int i = 0; i < S.length(); i++) {
    		char ch = S.charAt(i);
    		if (ch == '(') {
				stacks.push(ch);
			}else {
				stacks.pop();
			}
    		stringBuilder.append(ch);
    		if (stacks.isEmpty()) {
				resultString.append(stringBuilder.substring(1, stringBuilder.length() - 1));
				stringBuilder = new StringBuilder();
			}
			
		}
    	return resultString.toString();
    }
    
    /* 1047. 删除字符串中的所有相邻重复项
     * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
     * */
    public String removeDuplicates(String S) {
     	java.util.Stack<Character> stacks = new java.util.Stack<>();
    	for (int i = 0; i < S.length(); i++) {
    		char ch = S.charAt(i);
    		if (!stacks.isEmpty() && stacks.peek() == ch) {
				stacks.pop();
				
			}else {
				stacks.push(ch);
			}
			
		}
    	
    	StringBuilder sb = new StringBuilder();
    	ArrayList <Character> list = new ArrayList<>();
    	while (!stacks.isEmpty()) {
    		list.add(0, stacks.pop());
		}
    	while (list.size() != 0) {
    		sb.append(list.remove(0));
		}
    	    	
    	return sb.toString();
    }
    
}
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.backspaceCompare1("abcd", "bbcd"));
		System.out.println("---------------");
		
		System.out.println(solution.removeOuterParentheses("(()())(())"));
		
		System.out.println("---------------");
		
		System.out.println(solution.removeDuplicates("abbaca"));
		
		System.out.println("---------------");
		
		Stack<Integer> stack = new Stack<>();
		stack.push(11);
		stack.push(22);
		stack.push(33);
		stack.push(44);
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
