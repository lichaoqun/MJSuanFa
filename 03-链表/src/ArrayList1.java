

public class ArrayList1 <E> extends AbstractList<E> {
	
	// - 数组的元素地址
	private E[] elements;
	
	// - 默认开辟的存储空间
	private static final int DEFAULT_CAPATICY = 10;
	
	// - 初始化设置
	public ArrayList1() {
		this(DEFAULT_CAPATICY);
	} 
	public ArrayList1(int capaticy) {
		capaticy = Math.max(capaticy, DEFAULT_CAPATICY);
		this.expansionCapacity(capaticy);
	}

	
	private void setToNil(int index) {
		elements[index] = null;
	}
	
	private void expansionCapacity(int capacity) {
		int oldCapacity = (elements == null) ? 0 : elements.length;

		// - 内存足够大
		if (oldCapacity >= capacity) return;

		// - 扩容 (新容量是就容量的1.5倍)这里用右移是因为浮点型运算的性能损耗比右移的性能损耗高;
		int newCapacity = Math.max(DEFAULT_CAPATICY, oldCapacity + (oldCapacity >> 1));
		E[] newElements = (E[])new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapacity + "扩容为" + newCapacity);
	}
	
	// - 清空数组
	public void clear() {
		for (int i = 0; i < size; i++) {
			this.setToNil(i);
		}
		size = 0;
	}
	
	// - 获取指定下标的元素
	public E get(int index) {
		this.checkIndex(index);
		return elements[index];
	}
	
	// - 替换指定下标的元素
	public void set(int index, E element) {
		checkIndex(index);
		elements[index] = element;
	}
	
	// - 添加某个元素
	public void add(int index, E element) {
		checkIndexForAdd(index);
		
		// - 开辟空间
		this.expansionCapacity(size + 1);
		
		// - 移动元素
		for (int i = size; i > index; i--) {
			elements[i] = elements[i-1];
		}
		elements[index] = element;
		size++;
	}
	
	// - 删除某个元素
	public void remove(int index) {
		checkIndex(index);
		
		// - 移动元素
		for (int i = (index + 1); i < size; i++) {
			elements[i-1] = elements[i];
		}
		
		size--;
		this.setToNil(size);
		
		// - 以下是个简单写法
//		this.setToNil(--size);
	}

	// - 获取指定元素的下标 并适配null的情况
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) return i;
			}
		}else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("size = " + size + "; " + "elements = " + "[");
		for (int i = 0; i < size; i++) {
			if (i != 0 ) stringBuilder.append(", ");
			stringBuilder.append(elements[i]);
		}
		stringBuilder.append("];");
		return stringBuilder.toString();
	}

}
