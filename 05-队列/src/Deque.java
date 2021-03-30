/**
 * 
 */

/**
 * @author QG
 *
 */
public class Deque <E>{
	private TwoLineLinkedList <E> list = new TwoLineLinkedList<>();
	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void clear() {
		list.clear();
	}

	public void enQueueRear(E element) {
		list.add(element);
	}

	public void enQueueFront(E element) 
	{
		list.add(0, element);
	}

	public E deQueueFront() {
		E e = front();
		list.remove(0);
		return e;
	}

	public E deQueueRear() {
		E e = rear();
		list.remove(list.size() - 1);
		return e;
	}

	public E front() {
		return list.get(0);
	}

	public E rear() {
		return list.get(list.size() - 1);
	}
}
