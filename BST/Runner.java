package BST;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST tree = new BST(new int[] {10,20,30,40,50,60,70});
		tree.display();
		System.out.println(tree.find(55));
		System.out.println(tree.find(70));
		System.out.println(tree.max());
		
		tree.insert(65);
		tree.insert(98);
		System.out.println(tree.max());
		tree.display();
		System.out.println();
		tree.remove(65);
		tree.display();
		System.out.println();
		tree.remove(40);
		tree.display();
	}

}
