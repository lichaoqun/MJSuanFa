/**
 * 
 */
package 栈;

import java.util.Stack;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/crawler-log-folder/
 */
public class _1598_文件夹操作日志搜集器 {
	
	public int minOperations(String[] logs) {
		Stack<String> stack = new Stack<>();
		for (String string : logs) {
			if (string.equals("./")) continue;
			else if (string.equals("../")){
				if (!stack.isEmpty()) stack.pop();
			}else {
				stack.push(string);
			}
		}
		return stack.size();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_1598_文件夹操作日志搜集器 s = new _1598_文件夹操作日志搜集器();
		String[] str = {"d1/","d2/","../","d21/","./"};
		System.out.println(s.minOperations(str));
		
		String[] str1 = {"d1/","d2/","./","d3/","../","d31/"};
		System.out.println(s.minOperations(str1));
		
		String[] str2 = {"d1/","../","../","../"};
		System.out.println(s.minOperations(str2));
		
		String[] str3 = {"./","../","./"};
		System.out.println(s.minOperations(str3));
	}

}
