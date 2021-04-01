/**
 * 
 */
package 栈;

import java.util.ArrayList;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class _1047_删除字符串中的所有相邻重复项 {
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_1047_删除字符串中的所有相邻重复项 s = new _1047_删除字符串中的所有相邻重复项();
		System.out.println(s.removeDuplicates("abcd"));
		System.out.println(s.removeDuplicates("abbaca"));

	}

}
