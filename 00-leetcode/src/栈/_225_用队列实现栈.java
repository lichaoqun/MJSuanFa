/**
 * 
 */
package 栈;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class _225_用队列实现栈 {

    /** Push element x onto stack. */
	private Queue<Integer> q1 = new LinkedList<Integer>();
    private Queue<Integer> q2 = new LinkedList<Integer>();
	private Queue<Integer> currentQueue;
	
    public void push(int x) {
    	
    	// - 此时的两个队列都是空的
    	if (currentQueue == null) {
    		q1.offer(x);
    		currentQueue = q1;
    		return;
    	}
    	
    	// - 此时的队列中已经有值了
    	Queue <Integer> queue = (currentQueue == q1) ? q2 : q1;
    	queue.offer(x);
    	while (!currentQueue.isEmpty()) {
			queue.offer(currentQueue.poll());
		}
    	currentQueue = queue;    	
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	int result =  currentQueue.poll();
    	if (currentQueue.isEmpty()) {
			currentQueue = null;
		}
    	return result;
    }
    
    /** Get the top element. */
    public int top() {
    	return currentQueue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (currentQueue == null) return true;
    	return currentQueue.isEmpty();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_225_用队列实现栈  s = new _225_用队列实现栈();
		s.push(1);
		s.push(2);
		System.out.println(s.top());
		System.out.println(s.pop());
		System.out.println(s.empty());
	}

}
