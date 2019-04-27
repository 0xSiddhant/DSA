
public class EvenOdd {

	public static void main(String[] args) {
		checkEvenOdd(15);
		checkEvenOdd(9);
		checkEvenOdd(98);
		checkEvenOdd(10);
	}

	private static void checkEvenOdd(int no) {
		if((no& 1) == 1)
			System.out.println("Odd No");
		else
			System.out.println("Even No");
	}

}
