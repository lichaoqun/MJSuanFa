

public class ArrayList <E> {
	// - 数组长度
	private int mSize;
	
	// - 数组的元素地址
	private E[] mElements;
	
	private static final int DEFAULT_CAPATICY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;

	
	public ArrayList() {
		this(DEFAULT_CAPATICY);
	} 
	
	public ArrayList(int capaticy) {
		capaticy = Math.max(capaticy, DEFAULT_CAPATICY);
		this.expansionCapacity(capaticy);
	}
	
	private void checkIndex(int index) {
		if (index >= mSize || index < 0) {
			throw new IndexOutOfBoundsException("index is: " + index + ", size is: " + mSize);
		}
	}
	private void setToNil(int index) {
		mElements[index] = null;
	}

	private void expansionCapacity(int capacity) {
		int oldCapacity = (mElements == null) ? 0 : mElements.length;

		// - 内存足够大
		if (oldCapacity >= capacity) return;

		// - 扩容 (新容量是就容量的1.5倍)这里用右移是因为浮点型运算的性能损耗比右移的性能损耗高;
		int newCapacity = Math.max(DEFAULT_CAPATICY, oldCapacity + (oldCapacity >> 1));
		E[] newElements = (E[])new Object[newCapacity];
		for (int i = 0; i < mSize; i++) {
			newElements[i] = mElements[i];
		}
		mElements = newElements;
		System.out.println(oldCapacity + "扩容为" + newCapacity);
	}

	
	// - 清空数组
	public void clear() {
		for (int i = 0; i < mSize; i++) {
			this.setToNil(i);
		}
		mSize = 0;
	}
	
	// - 数组长度
	public int size() {
		return mSize;
	}
	
	// - 数组是不是空的
	public boolean isEmpty() {
		return (mSize == 0);
	}
	
	// - 是否包含某个元素
	public boolean contains(E element) {
		return (this.indexOf(element) != ELEMENT_NOT_FOUND);
	}
	
	// - 添加某个元素
	public void add(E element) {
		this.add(mSize, element);
	}
	
	// - 获取指定下标的元素
	public E get(int index) {
		this.checkIndex(index);
		return mElements[index];
	}
	
	// - 替换指定下标的元素
	public void set(int index, E element) {
		mElements[index] = element;
	}
	
	// - 添加某个元素
	public void add(int index, E element) {
		this.expansionCapacity(mSize + 1);
		for (int i = mSize; i > index; i--) {
			System.out.println("tet");
			mElements[i] = mElements[i-1];
		}
		mElements[index] = element;
		mSize++;
	}
	
	// - 删除某个元素
	public void remove(int index) {
		for (int i = (index + 1); i < mSize; i++) {
			mElements[i-1] = mElements[i];
		}
		
		mSize--;
		this.setToNil(mSize);
		
		// - 以下是个简单写法
//		this.setToNil(--mSize);
	}
	
	// - 删除某个元素
	public void remove(E element) {
		this.remove(indexOf(element));
	}

	// - 获取指定元素的下标 并适配null的情况
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < mSize; i++) {
				if (mElements[i] == null) return i;
			}
		}else {
			for (int i = 0; i < mSize; i++) {
				if (element.equals(mElements[i])) return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("size = " + mSize + "; " + "elements = " + "[");
		for (int i = 0; i < mSize; i++) {
			if (i != 0 ) stringBuilder.append(", ");
			stringBuilder.append(mElements[i]);
		}
		stringBuilder.append("];");
		return stringBuilder.toString();
	}

}
