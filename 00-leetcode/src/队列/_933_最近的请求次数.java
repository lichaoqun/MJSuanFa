/**
 * 
 */
package 队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lichaoqun
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 */
public class _933_最近的请求次数 {
	private Queue <Integer> q = new LinkedList();
    public int ping(int t) {
        q.offer(t);
        while (q.peek() < t - 3000)
            q.poll();
        return q.size();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_933_最近的请求次数 s = new _933_最近的请求次数();
		System.out.println(s.ping(5));
		System.out.println(s.ping(5));
		System.out.println(s.ping(5));
	}

}
