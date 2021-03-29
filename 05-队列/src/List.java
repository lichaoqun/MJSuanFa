
public interface List <E>{
	
	static final int ELEMENT_NOT_FOUND = -1;	
	// - 数组长度
	public int size();
	
	// - 数组是不是空的
	public boolean isEmpty();
	
	// - 是否包含某个元素
	public boolean contains(E element);
	
	// - 添加某个元素
	public void add(E element);
	
	// - 清空数组
	void clear();
		
	// - 获取指定下标的元素
	E get(int index);
	
	// - 替换指定下标的元素
	void set(int index, E element);
	
	// - 添加某个元素
	void add(int index, E element);
	
	// - 删除某个元素
	void remove(int index);
	
	// - 删除某个元素
	void remove(E element);

	// - 获取指定元素的下标 并适配null的情况
	int indexOf(E element);
}
