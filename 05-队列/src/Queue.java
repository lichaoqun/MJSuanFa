/**
 * 
 */

/**
 * @author QG
 *
 */
public class Queue <E> {
	private TwoLineLinkedList<E> list = new TwoLineLinkedList<>();
	
	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void clear() {
		list.clear();
	}

	public void enQueue(E element) {
		list.add(element);
	}

	public E deQueue() {
		E e = front();
		list.remove(0);
		return e;
	}

	public E front() {
		return list.get(0);
	}
	
	
}
