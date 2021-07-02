import printer.BinaryTrees;

import java.util.Comparator;

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
		
		AVLTree<Integer> bst = new AVLTree<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return 0;
			}
		});
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
//		BinaryTrees.println(bst);
//		bst.reverseTree();
//		sep();
		BinaryTrees.println(bst);
		sep();
		bst.preorderTraversal3();
		sep();
	}
	
	public static void sep() {
		System.out.println("---------------------------------------------");
	}

}
