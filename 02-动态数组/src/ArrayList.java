import java.util.Iterator;

public class ArrayList {
	// - 数组长度
	private int mSize;
	
	// - 数组的元素地址
	private int[] mElements;
	
	private static final int DEFAULT_CAPATICY = 10;
	public static final int ELEMENT_NOT_FOUND = -1;

	
	public ArrayList() {
		this(DEFAULT_CAPATICY);
	}
	
	public ArrayList(int capaticy) {
		capaticy = capaticy > DEFAULT_CAPATICY ? capaticy : DEFAULT_CAPATICY;
		mElements = new int[capaticy];
	}
	
	private void checkIndex(int index) {
		if (index >= mSize || index < 0) {
			throw new IndexOutOfBoundsException("index is: " + index + ", size is: " + mSize);
		}
	}
	
	// - 清空数组
	public void clear() {
		
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
	public boolean contains(int element) {
		return (this.get(element) != ELEMENT_NOT_FOUND);
	}
	
	// - 添加某个元素
	public void add(int element) {
		
	}
	
	// - 获取指定下标的元素
	public int get(int index) {
		this.checkIndex(index);
		return mElements[index];
	}
	
	// - 替换指定下标的元素
	public int set(int index, int element) {
		int oldValue = this.get(index);
		mElements[index] = element;
		return oldValue;
	}
	
	// - 添加某个元素
	public void add(int index, int element) {
		
	}
	
	// - 删除某个元素
	public int remove(int index) { 
		return -1;
	}

	// - 获取指定元素的下标
	public int indexOf(int element) {
		for (int i = 0; i < mSize; i++) {
			if (mElements[i] == element) return i;
		}
		return ELEMENT_NOT_FOUND;
	}

}
