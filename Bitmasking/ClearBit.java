
public class ClearBit {

	public static void main(String[] args) {

		clearIthBit(15,2);
	}

	private static void clearIthBit(int i, int j) {

		int mask = 1 << j;
		mask = ~mask;
		System.out.println(i & mask);
	}

}
