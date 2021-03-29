/**
 * 
 */

/**
 * @author QG
 *
 */
public class Stack <E>{
	private ArrayList1<E>list1 = new ArrayList1<>();
	
	public void clear() {
		list1.clear();
	}
	
	public int size() {
		return list1.size();
	}

	public boolean isEmpty() {
		return list1.isEmpty();
	}

	public void push(E element) {
		list1.add(element);
	}


	public E pop() {
		E e = top();
		list1.remove(list1.size() - 1);
		return e;
	}


	public E top() {
		return list1.get(list1.size()  -1);
	}
}