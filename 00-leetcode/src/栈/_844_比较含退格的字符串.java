/**
 * 
 */
package 栈;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class _844_比较含退格的字符串 {
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_844_比较含退格的字符串 s = new _844_比较含退格的字符串();
		System.out.println(s.backspaceCompare("ab#c", "ad#c"));
		System.out.println(s.backspaceCompare("ab##", "c#d#")); 
		System.out.println(s.backspaceCompare("a##c", "#a#c")); 
		System.out.println(s.backspaceCompare("a#c", "b")); 
	}

}
