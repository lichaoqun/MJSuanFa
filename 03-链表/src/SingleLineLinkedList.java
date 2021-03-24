
public class SingleLineLinkedList <E> extends AbstractList<E>{
	
	private static class Node <E> {
		E element;
		Node <E> next;
		public Node(E element, SingleLineLinkedList.Node<E> next) {
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
		if (index ==0) {
			first = new Node<>(element, first);
			size++;
			return;
		}
		Node<E>prev = node(index - 1);
		prev.next = new Node<>(element, prev.next);
		size++;
	}

	@Override 
	public void remove(int index) {
		// TODO Auto-generated method stub 
		if (index == 0) {
			first = first.next;
			size--;
			return;
		}
		Node<E>prev = node(index - 1);
		prev.next = prev.next.next;
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
