

public class SingleCircleLinkedList <E> extends AbstractList<E>{
	
	private static class Node <E> {
		E element;
		Node <E> next;
		public Node(E element, SingleCircleLinkedList.Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}		
	}
	
	private Node <E> first;

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		first = null;
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

		// - 当前没有元素
		if (size == 0) {
			Node <E> node = new Node<>(element, null);
			node.next = node;
			first = node;
			size++;
			return;
		}
		
		if (index == 0) { // - 头部插入
			Node <E> newFirst = new Node<>(element, first);
			Node<E> last = node(index - 1);
			last.next = first = newFirst;
		}else if (index == size){// - 尾部插入
			Node<E> oldLast = node(index - 1);
			Node <E> newLast = new Node<>(element, oldLast.next);
			oldLast.next = newLast;
		}else {// - 中间插入
			Node<E> prev = node(index - 1);
			Node <E> node = new Node<>(element, prev.next);
			prev.next = node;
		}
		size++;
	}

	@Override 
	public void remove(int index) {
		// TODO Auto-generated method stub 		
		
		// - 只有一个元素
		if (size == 1) {
			first = null;
			size--;
			return;
		}
	
		if (index == 0) { // - 删除第一个
			Node<E> last = node(size - 1);
			first = first.next;
			last.next = first;
		}else if (index == size - 1) { // - 删除最后一个
			Node<E> prev = node(index - 1);
			prev.next = first;
		}else { // - 删除中间的元素
			Node<E> prev = node(index - 1);
			prev.next = prev.next.next;
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
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
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
