

public class Swap2No {

	public static void main(String[] args) {

		int a = 5, b = 7;
		a = a ^ b;// 5 ^ 7
		b = a^b;// 7 ^ 5 ^ 7 = 5
		a = a^b;// 5 ^ 7 ^ 5 = 7
		System.out.println(a+" "+b);
	}

}
