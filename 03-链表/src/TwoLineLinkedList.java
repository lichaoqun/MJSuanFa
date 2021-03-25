

public class TwoLineLinkedList <E> extends AbstractList<E>{
	
	private static class Node <E> {
		E element;
		Node <E> next;
		Node <E> prev;
		public Node(Node<E> prev, E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
			this.prev = prev;
		}		
	}
	
	private Node <E> first;
	private Node <E> last;
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		first = null;
		last = null;
	}


	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkIndex(index);
		Node<E> node = node(index);
		return node.element;
	}

	@Override
	public void set(int index, E element) {
		// TODO Auto-generated method stub
		checkIndex(index);
		Node<E> node = node(index);
		node.element = element;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		checkIndexForAdd(index);
		
		// - 当前链表没有元素
		if (size == 0) {
			Node<E> node = new Node<>(null, element, null);
			first = last = node;
			size++;
			return;
		}

		if (index == 0) {// - 插入在头部
			Node<E> oldFirst = first;
			first = new Node<>(null, element, oldFirst);
			oldFirst.prev = first;
		}else if (index == size) { // - 插入在尾部
			Node<E> oldLast = last;
			last = new Node<>(oldLast, element, null);
			oldLast.next = last;
		} else {// - 插入在中间
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> node = new Node<>(prev, element, next);
			next.prev = prev.next = node;
		}
		size++;
	}

	@Override 
	public void remove(int index) {
		checkIndex(index);
		Node<E> node = node(index);
		Node<E> next = node.next;
		Node<E> prev = node.prev;
		
		if (index == 0) { // - 删除头部
			next.prev = null;
			first = next;
		}else if (index == size) { // - 删除尾部
			prev.next = null;
			last = prev;
		}else { // - 删除中间
			prev.next = next;
			next.prev = prev;
		}

		size--;
	}

	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		Node<E>node = first;
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i;
				node = node.next;
			}
		}else {
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) return i;
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	private Node<E> node(int index) {
		checkIndex(index);
		// - 查找的坐标 < 长度的一半, 从前遍历, 否则从后遍历
		// - 从前往后遍历
		if (index < (size >> 1)) {
			Node <E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		}else{ // - 从后往前遍历
			Node<E> node = last;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
			return node;
		}
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("size = " + size + "; " + "elements = " + "[");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0 ) stringBuilder.append(", ");
			stringBuilder.append(node.element);
			node = node.next;
		}
		stringBuilder.append("];");
		return stringBuilder.toString();
		
		/* 另一种遍历方式
		 * 
			Node<E>node = first;
			while (node != null) {
				node = node.next;
			};
		 * */
	}
}
