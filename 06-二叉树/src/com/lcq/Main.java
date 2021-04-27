package com.lcq;
import com.lcq.BinarySearchTree.Visitor;
import com.lcq.printer.BinaryTrees;

/**
 * 
 */

/**
 * @author QG
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 5, 8, 11, 1, 3, 10, 12
		};
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		BinaryTrees.println(bst);

		bst.postorderTraversal3();
	}

}
