
public class AddOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			addOne(21);
	}

	private static void addOne(int n) {

		int mask = 1;
		
		while( (n & mask) != 0) {
			n = n ^ mask;
			mask = (mask << 1);
		}
		n = n ^ mask;
		System.out.println(n);
	}

}
