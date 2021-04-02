/**
 * 
 */
package 栈;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/min-stack/
 */
public class _155_最小栈 {
    /** initialize your data structure here. */
	
	// - 方案一
	// - 大->小
	private List<Integer> assisLinkList = new LinkedList<>();
	private List<Integer> stack = new ArrayList<>();

    public void push(int val) {
    	stack.add(val);
    	// - 遍历找到第一个 val 小的, 并且保存
    	boolean addToArray = false;
    	for (int i = 0; i < assisLinkList.size(); i++) {
    		int va = assisLinkList.get(i);
    		if (va < val) {
    			assisLinkList.add(i, val);
    			addToArray = true;
    			break;
			}
		}
    	
    	// - 如果之前没有找到比val小的放在最后的位置
    	if (!addToArray) {
    		assisLinkList.add(val);
		}
    }
    
    public void pop() {
    	int val = top();
    	stack.remove(stack.size() - 1);
    	assisLinkList.remove(assisLinkList.indexOf(val));
    }
    
    public int top() {
    	return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
    	return assisLinkList.get(Math.max(assisLinkList.size() - 1, 0));
    }

	// - 方案二
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public _155_最小栈() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }
    public void push2(int val) {
    	xStack.push(val);
    	minStack.push(Math.min(val, minStack.peek()));
    }
    
    public void pop2() {
    	xStack.pop();
    	minStack.pop();
    }
    
    public int top2() {
        return xStack.peek();
    }
    
    public int getMin2() {
        return minStack.peek();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_155_最小栈 minStack = new _155_最小栈();
		minStack.push(0);
		minStack.push(1);
		minStack.push(0);
		System.out.println(minStack.getMin());
		minStack.pop();
		
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}
}

