/**
 * 
 */

/**
 * @author QG
 *
 */
public class Main {
	public static void main(String[] args) {
//		Queue<Integer> queue = new Queue<>();
//		queue.enQueue(11);
//		queue.enQueue(22);
//		queue.enQueue(33);
//		queue.enQueue(44);
//		
//		while (!queue.isEmpty()) {
//			System.out.println(queue.deQueue());
//		}
		
		Deque<Integer> queue1 = new Deque<>();
		queue1.enQueueFront(11);
		queue1.enQueueFront(22);
		queue1.enQueueRear(33);
		queue1.enQueueRear(44);
		
		/* 尾  44  33   11  22 头 */
		
		while (!queue1.isEmpty()) {
			System.out.println(queue1.deQueueRear());
		}
	}
}
