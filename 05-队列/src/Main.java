/**
 * 
 */

/**
 * @author QG
 *
 */
public class Main {
	public static void main(String[] args) {
		String string = "----------------------------";
		System.out.println(string);
		Queue<Integer> queue = new Queue<>();
		queue.enQueue(11);
		queue.enQueue(22);
		queue.enQueue(33);
		queue.enQueue(44);
		
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
		
		System.out.println(string);
		
		Deque<Integer> queue1 = new Deque<>();
		queue1.enQueueFront(11);
		queue1.enQueueFront(22);
		queue1.enQueueRear(33);
		queue1.enQueueRear(44);
		
		/* 尾  44  33   11  22 头 */
		
		while (!queue1.isEmpty()) {
			System.out.println(queue1.deQueueRear());
		}
		
		System.out.println(string);
		
		
		CycleQueue<Integer> c = new CycleQueue<>();
		// - 0 1 2 3 4 5 6 7 8 9
		for (int i = 0; i < 10; i++) {
			c.enQueue(i);
		}
		System.out.println(c);
		
		// null null null null null 5 6 7 8 9
		for (int i = 0; i < 5; i++) {
			c.deQueue();
		}
		System.out.println(c);

		// 15 16 17 18 19 5 6 7 8 9
		for (int i = 15; i < 20; i++) {
			c.enQueue(i);
		}
		System.out.println(c);
		
		System.out.println(string);
		
		CycleDeque<Integer> cd = new CycleDeque<>();
		
		// 头 8 7 6  5 4 3 2 1  100 101 102 103 104 105 106 107 108 109 null null 10 9 尾
		for (int i = 0; i < 10; i++) {
			cd.enQueueFront(i + 1);
			cd.enQueueRear(i + 100);

		}
		System.out.println(cd);
		
		// 头 null 7 6  5 4 3 2 1  100 101 102 103 104 105 106 null null null null null null null 尾
		for (int i = 0; i < 3; i++) {
			cd.deQueueFront();
			cd.deQueueRear();
		}
		System.out.println(cd);
		
		// 头 11 7 6  5 4 3 2 1  100 101 102 103 104 105 106 null null null null null null 12 尾
		cd.enQueueFront(11);
		cd.enQueueFront(12);
		System.out.println(cd);
		
		System.out.println(string);
	}
}
