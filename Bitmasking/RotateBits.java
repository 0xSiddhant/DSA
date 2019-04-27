
public class RotateBits {

	public static void main(String[] args) {

		leftRotate(5,2);
	}

	private static void leftRotate(int no, int r) {

		int a = no<<r;
		int b = no>>(32-r);
		System.out.println((a|b));
	}

}
