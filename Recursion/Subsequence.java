
public class Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printSubSequence("abcd", "");
	}

	private static void printSubSequence(String str, String res) {

		if (str.length() == 0) {
			System.out.println(res);
			return;
		}

		printSubSequence(str.substring(1), res);
		printSubSequence(str.substring(1), res + str.charAt(0));
	}

}
