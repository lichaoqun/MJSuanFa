package com.lcq;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.lcq.printer.BinaryTreeInfo;

public class BinarySearchTree <E> implements BinaryTreeInfo{
	
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
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuilder sb = new StringBuilder();
			return sb.append("(" + this.element + ")").toString();
		}
	}
	
	public static abstract class Visitor<E> {
		boolean stop;
		/**
		 * @return 如果返回true，就代表停止遍历
		 */
		public abstract boolean visit(E element);
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
		int lastCmpResult = 0;
		Node<E> curNode  = root;
		Node<E>lastParentNode = root;
		while (curNode != null) {
			lastCmpResult = compare(element, curNode.element);
			lastParentNode = curNode; 
			
			if (lastCmpResult == 0) {
				curNode.element = element;
				return;
			}
			curNode = (lastCmpResult > 0) ? curNode.right : curNode.left;	
		}
		
		curNode = new Node <>(element, lastParentNode);
		if (lastCmpResult > 0) {
			lastParentNode.right = curNode;
		}else {
			lastParentNode.left = curNode;
		}
		
		// - 增加节点数量
		size++;
	}
	
	public void remove(E element) {
		remove(node(element));
	}

	public boolean contains(E element) {
		return node(element) != null;
	}
	
	/* 遍历 */
	// - 前序遍历
	public void preorderTraversal1() {
		preorderTraversal1(root);
	}
	public void preorderTraversal1(Node<E>node) {

		if (node == null) return;
		System.out.println(node);
		preorderTraversal1(node.left);
		preorderTraversal1(node.right);
	}
	public void preorderTraversal2(Visitor<E> visitor) {
		if (visitor == null) return;
		preorderTraversal2(root, visitor);
	}
	public void preorderTraversal2(Node<E>node, Visitor<E> visitor) {
		if (node == null || visitor.stop) return;
		visitor.stop = visitor.visit(node.element);
		if (visitor.stop ) return;
		preorderTraversal2(node.left, visitor);
		preorderTraversal2(node.right, visitor);
	}
	public void preorderTraversal3() {
		Stack<Node<E>> stack = new Stack<>();
		Node<E>node = root;
		while (true) {
			if (node != null) {
				System.out.println(node);
				stack.push(node.right);
				node = node.left;
			} else {
				if (stack.isEmpty()) return;
				node = stack.pop();
			}
		}
	}
	public void preorderTraversal4(Visitor<E> visitor) {
		Stack<Node<E>> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node<E> node = stack.pop();
			visitor.stop = visitor.visit(node.element);
			if (visitor.stop ) return;
			if (node.right != null) stack.push(node.right);
			if (node.left != null) stack.push(node.left);
		}
	}
	
	// - 中序遍历
	public void inorderTraversal1() {
		inorderTraversal1(root);
	}
	public void inorderTraversal1(Node<E>node) {
		if (node == null) return;
		inorderTraversal1(node.left);
		System.out.println(node);
		inorderTraversal1(node.right);
	}
	
	public void inorderTraversal2(Visitor<E>visitor) {
		if (visitor == null) return;
		inorderTraversal2(root, visitor);
	}
	public void inorderTraversal2(Node<E>node, Visitor<E>visitor) {
		if (node == null || visitor.stop) return;
		inorderTraversal2(node.left, visitor);
		boolean stop = visitor.visit(node.element);
		if (stop) return;
		inorderTraversal2(node.right, visitor);
	}
	public void inorderTraversal3() {
		Stack<Node<E>> stack = new Stack<>();
		Node<E>node = root;
		while (true) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			}else {
				if (stack.isEmpty()) return;
				node = stack.pop();
				System.out.println(node.element);
				node = node.right;
			}
		}
	}
	
	// - 后序遍历
	public void postorderTraversal1() {
		postorderTraversal1(root);
	}
	public void postorderTraversal1(Node<E>node) {
		if (node == null) return;
		postorderTraversal1(node.left);
		postorderTraversal1(node.right);
		System.out.println(node);
	}
	public void postorderTraversal2(Visitor<E>visitor) {
		if (visitor == null) return;
		postorderTraversal2(root, visitor);
	}
	public void postorderTraversal2(Node<E>node, Visitor<E>visitor) {
		if (node == null || visitor.stop) return;
		postorderTraversal2(node.left, visitor);
		postorderTraversal2(node.right, visitor);
		boolean stop = visitor.visit(node.element);
		if (stop) return;
	}
	public void postorderTraversal3() {
		Stack<Node<E>> stack = new Stack<>();
		Node<E>node = root;
		stack.push(node);
		Node<E>lastNode = null;
		while (!stack.isEmpty()) {
			node = stack.peek();
			if (node.isLeaf() || lastNode == node.left || lastNode == node.right) {
				System.out.println(node.element);
				stack.pop();
				lastNode = node;
			}else {
				stack.push(node.right);
				stack.push(node.left);
			}
		};
	}
	
	// - 层序遍历
	public void levelOrderTraversal1() {
		if (root == null) return;
		
		Queue<Node<E>>queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E>node = queue.poll();
			System.out.println(node.element);
			if (node.left != null) { 
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}
	public void levelOrderTraversal2(Visitor<E>visitor) {
		if (root == null || visitor == null) return;
		
		Queue<Node<E>>queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E>node = queue.poll();
			if(visitor.visit(node.element)) return;
			if (node.left != null) { 
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}
	
	// - 判断是不是完全二叉树 (层序遍历到)
	/**
	 * 按层序遍历二叉树, 从每层的左边向右边依次遍历所有的节点.
	 * 如果当前节点有右孩子, 但是没有左孩子, 直接返回false.
	 * 如果当前节点并不是左右孩子全有, 那之后的节点必须都为叶节点, 否则返回false.
	 * 遍历过程中如果不返回false, 遍历结束后返回true.
	 * */
	public boolean isComplete() {
		if(null == root) return false;
		
		Queue<Node<E>> queue = new LinkedList<>();
		
		// - 只存在右子树的子节点
		boolean hasleaf = false;
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E>node = queue.poll();

			// - 完全二叉树, 如果之前已经存在只有右子树的子节点, 那个节点后边的每一个叶子节点都必须是叶子节点. 
			if (hasleaf && !node.isLeaf()) return false;

			if (node.left != null) {
				queue.offer(node.left);
			}else if (node.right != null) {
				// - 节点没有左子树,只有右子树, 这个数就不是完全二叉树.
				return false;
			}
			
			// - 走到这, 说明(左子树存在右子树有可能存在, 有可能不存在. 或者左子树不存在并且右子树不存在)
			if (node.right != null) {
				queue.offer(node.right);
			}else {
				// - 左子树存在, 右子树不存在, 或者左右子树都不存在(左右子树不同时存在)
				hasleaf = true;
			}
		}
		return true;
	}
	
	/**
	 * 层序遍历二叉树,  保存每层的节点的个数,  每遍历完一次,  树的高度 + 1;
	 * */
	// - 二叉树的高度
	public int height() {
		if (root == null) return 0;
		int height = 0;
		int levelSize = 1;
		
		Queue<Node<E>>queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node<E>node = queue.poll();
			levelSize --;
			
			if(node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			
			if (levelSize == 0) {
				levelSize = queue.size();
				height++;
			}
		}
		
		return height;
	}
	
	public int height2() {
		return height(root);
	}
	
	public int height(Node<E>node) {
		if (node == null) return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	// - 根据元素找到节点
	private Node<E> node(E element) {
		// - 检查元素
		elementCheck(element);
		
		// - 查找
		Node<E>curNode = root;
		while(curNode != null) {
			int cmpResult = compare(element, curNode.element);
			if (cmpResult == 0) return curNode;
			curNode = (cmpResult > 0) ? curNode.right : curNode.left;   
		}
		return null;
	}
	
	// - 前驱结点
	private Node<E> predecessor(Node<E>node) {
		
		// - 前驱结点在左子树中(node.left.right.right.right.right.right....right);
		Node<E>p = node.left;
		if (p != null) {
			while (p.right != null) {
				p = p.right;
			}
			return p;
		}
		
		// 从父节点、祖父节点中寻找前驱节点
		while (node.parent != null && node.parent.left == node) {
			node = node.parent;
		}
		return node.parent;
	}
	
	// - 后继节点
	private Node<E> successor(Node<E>node) {
		// - 后集结点在右子树中(node.right.left.left.left.left.left....left);
		Node<E>p = node.right;
		if (p != null) {
			while (p.left != null) {
				p = p.left;
			}
			return p;
		}
		
		// 从父节点、祖父节点中寻找前驱节点
		while (node.parent != null && node.parent.right == node) {
			node = node.parent;
		}
		return node.parent;
	}
	
	private void remove(Node<E> node) {
		if (node == null) return;
		
		size--;
		
		if (node.hasTwoChildren()) { // 度为2的节点
			// 找到后继节点
			Node<E> s = successor(node);
			// 用后继节点的值覆盖度为2的节点的值
			node.element = s.element;
			// 删除后继节点
			node = s;
		}
		
		// 删除node节点（node的度必然是1或者0）
		Node<E> replacement = node.left != null ? node.left : node.right;
		
		if (replacement != null) { // node是度为1的节点
			// 更改parent
			replacement.parent = node.parent;
			// 更改parent的left、right的指向
			if (node.parent == null) { // node是度为1的节点并且是根节点
				root = replacement;
			} else if (node == node.parent.left) {
				node.parent.left = replacement;
			} else { // node == node.parent.right
				node.parent.right = replacement;
			}
		} else if (node.parent == null) { // node是叶子节点并且是根节点
			root = null;
		} else { // node是叶子节点，但不是根节点
			if (node == node.parent.left) {
				node.parent.left = null;
			} else { // node == node.parent.right
				node.parent.right = null;
			}
		}
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
	@Override
	public Object root() {
		return root;
	}

	@Override
	public Object left(Object node) {
		return ((Node<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		return ((Node<E>)node).right;
	}

	@Override
	public Object string(Object node) {
		Node<E> myNode = (Node<E>)node;
		String parentString = "null";
		if (myNode.parent != null) {
			parentString = myNode.parent.element.toString();
		}
		return myNode.element;
	}
}
