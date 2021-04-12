import java.util.Comparator;

public class BinarySearchTree <E> {
	
	// - 节点类
	private static class Node<E> {
		E element;
		Node <E> left;
		Node <E> right;
		Node <E> parent;
		
		public Node (E element, Node<E>parent) {
			this.element = element;
			this.parent = parent;
		}
		
		public boolean isLeaf() {
			return  (this.left == null) && (this.right == null);
		}
		
		public boolean hasTwoChildren() {
			return  (this.left != null) && (this.right != null);
		}
	}
	
	
	// - 树的节点的个数
	private int size;
	
	// - 根节点
	private Node <E> root;
	
	// - 比较器
	private Comparator <E> comparator;
	
	// - 初始化方法
	public BinarySearchTree() {
		this(null);
	}
	
	public BinarySearchTree(Comparator <E> comparator) {
		this.comparator = comparator;
	}
	
	// - 节点的个数
	public int size (){
		return this.size;
	}
	
	// - 判断二叉树是不是空
	public boolean isEmpty() {
		return (size == 0);
	}
	
	// - 清空二叉树
	public void clear() {
		root = null;
		size = 0;
	}
	
	// - 添加节点
	public void add(E element) {
		
		// - 检测element
		elementCheck(element);
		
		// - 没有根节点, 这是第一个节点;
		if(root == null) {
			root = new Node<>(element, null);
			size++;
			return;
		}
		
		// - 已经有根节点, 遍历每个节点的element和当前节点的element比较, 如果当前的值>当前节点的值, 则作为左子节点, 否则作为右子节点;
		int cmp = 0;
		Node<E> node  = root;
		Node<E>parent = root;
		while (node != null) {
			cmp = compare(element, node.element);
			parent = node; 
			
			if (cmp > 0) {
				node = node.right;
			} else if (cmp > 0){
				node = node.left;
			}else{
				node.element = element;
				return;
			}			
		}
		
		node = new Node <>(element, parent);
		if (cmp > 0) {
			parent.right = node;
		}else {
			parent.left = node;
		}
		
		// - 增加节点数量
		size++;
	}
	
//	public void remove(E element) {
//		remove(node(element));
//	}
//
//	public boolean contains(E element) {
//		return node(element) != null;
//	}
	
	// - 根据元素找到节点
	private Node<E> node(E element) {
		// - 检查元素
		elementCheck(element);
		
		// - 查找
		Node<E>node = root;
		while(node != null) {
			int cmp = compare(element, node.element);
		}
		return null;
	}
	
	// - 节点的元素检查
	private void elementCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}
	
	// - 兼容不传入比较器和传入比较器的情况
	private int compare(E e1, E e2) {
		if (this.comparator != null) {
			return this.comparator.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
	}
	
	
}
