package BinaryTree;

public class Runner {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.display();
		System.out.println("Height of tree is " +tree.height());
		
		tree.preOrder();
		tree.postOrder();
		tree.inOrder();
		tree.levelOrder();
		tree.mirrorTree();
		tree.display();
		// Test case 1:
		// 50 true 20 true 38 false false true 48 true 18 false false false true 45 true 85 false false true 60 false false
		
		// Test case 2:
	}

}
