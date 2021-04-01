/**
 * 
 */
package 栈;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 */
public class _1021_删除最外层的括号 {
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
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_1021_删除最外层的括号 s =new _1021_删除最外层的括号();
		System.out.println(s.removeOuterParentheses("(()())(())"));
		System.out.println(s.removeOuterParentheses("(()())(())(()(()))"));
		System.out.println(s.removeOuterParentheses("()()"));
	}

}
