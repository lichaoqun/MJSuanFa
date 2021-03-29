
public abstract class AbstractList <E> implements List<E>{
	
	// - 长度的成员变量
	protected int size;
	
	// - 判断越界问题
	public void checkIndex(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("index is: " + index + ", size is: " + size);
		}
	}
	// - 判断越界问题
	public void checkIndexForAdd(int index) {
		if (index < 0 || index > size)  {
			throw new IndexOutOfBoundsException("index is: " + index + ", size is: " + size);
		}
	}
	
	// - 数组长度
	public int size() {
		return size;
	}
	
	// - 数组是不是空的
	public boolean isEmpty() {
		return (size == 0);
	}
	
	// - 是否包含某个元素
	public boolean contains(E element) {
		return (this.indexOf(element) != ELEMENT_NOT_FOUND);
	}
	
	// - 添加某个元素
	public void add(E element) {
		this.add(size, element);
	}

	@Override
	public void remove(E element) {
		// TODO Auto-generated method stub
		remove(indexOf(element));
	}
}
