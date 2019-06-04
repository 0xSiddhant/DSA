
public class PowerOfTwo {

	public static void main(String[] args) {

		System.out.println(powerOfTwo(7));
		System.out.println(powerOfTwo(8));
	}

	private static boolean powerOfTwo(int n) {
		// TODO Auto-generated method stub
		if (n == 0)
			return false;
		return ((n & (n-1)) == 0? true: false);
	}

}
