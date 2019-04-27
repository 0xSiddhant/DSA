public class AVLRunner {

	public static void main(String[] args) {

		m1();
		System.out.println();
		m2();

	}

	private static void m2() {

		AVLTree t = new AVLTree();
		t.insert(20);
		t.insert(25);
		t.insert(30);
		t.insert(10);
		t.insert(5);
		t.insert(15);
		t.insert(27);
		t.insert(19);
		t.insert(16);
		t.display();

	}

	private static void m1() {
		AVLTree t = new AVLTree();
		t.insert(32);
		t.insert(12);
		t.insert(7);
		t.insert(56);
		t.insert(98);
		t.insert(76);
		t.insert(97);
		t.display();
	}

}
