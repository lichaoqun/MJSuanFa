
public class CycleDeque <E>{
	private int head;
	private int elementCount;
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;

	public CycleDeque() {
		// TODO Auto-generated constructor stub
		elementCount = 0;
		expansionCapacity(DEFAULT_CAPACITY);
	}
	
	private void expansionCapacity(int capacity) {
		int oldCapacity = (elements == null) ? 0 : elements.length;

		// - 内存足够大
		if (oldCapacity >= capacity) return;

		// - 扩容 (新容量是就容量的1.5倍)这里用右移是因为浮点型运算的性能损耗比右移的性能损耗高;
		int newCapacity = Math.max(DEFAULT_CAPACITY, oldCapacity + (oldCapacity >> 1));
		
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < elementCount; i++) {
			newElements[i] = elements[index(i)];
		}
		elements = newElements;
		
		// 重置front
		head = 0;
	}
	
	private int index(int index) {
		index += head;
		if (index < 0) {
			return index + elements.length;
		}
		return index % elements.length;
	}
	
	public int size() {
		return elementCount;
	}

	public boolean isEmpty() {
		return elementCount == 0;
	}
	
	public void clear() {
		for (int i = 0; i < elementCount; i++) {
			elements[index(i)] = null;
		}
		head = 0;
		elementCount = 0;
	}

	/**
	 * 从尾部入队
	 * @param element
	 */
	public void enQueueRear(E element) {
		expansionCapacity(elementCount + 1);
		elements[index(elementCount)] = element;
		elementCount++;
	}

	/**
	 * 从头部出队
	 * @param element
	 */
	public E deQueueFront() {
		E result = elements[head];
		elements[head] = null;
		head = index(1);
		elementCount--;
		return result;
	}

	/**
	 * 从头部入队
	 * @param element
	 */
	public void enQueueFront(E element) {
		expansionCapacity(elementCount + 1);
		head = index(-1);
		elements[head] = element;
		elementCount++;
	}

	/**
	 * 从尾部出队
	 * @param element
	 */
	public E deQueueRear() {
		int index = index(elementCount - 1);
		E result = elements[index];
		elements[index] = null;
		elementCount--;
		return result;
	}

	public E front() {
		return elements[head];
	}

	public E rear() {
		return elements[index(elementCount - 1)];
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("capcacity=").append(elements.length)
		.append(" size=").append(elementCount)
		.append(" front=").append(head)
		.append(", [");
		for (int i = 0; i < elements.length; i++) {
			if (i != 0) {
				string.append(", ");
			}
			
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();
	}
}
