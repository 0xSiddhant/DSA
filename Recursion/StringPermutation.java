import java.util.ArrayList;

public class StringPermutation {

	public static void main(String[] args) {
		System.out.println(getPermutation("abc"));
		printPermutation("abc", "");
	}

	private static void printPermutation(String str, String res) {

		if (str.length() == 0) {
			System.out.println(res);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			printPermutation(str.substring(0, i) + str.substring(i + 1), res + str.charAt(i));
		}
	}

	/*
	 * mr = my result rr = return result ros = rest of string
	 */
	private static ArrayList<String> getPermutation(String str) {

		// 3rd Step -----> Base Case
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		// 1st Step
		char c = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = getPermutation(ros);

		// 2nd Step
		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {
			// loop --- 0 to length i.e ==> 0 to str.length();
			for (int i = 0; i <= rrs.length(); i++) {
				String val = rrs.substring(0, i) + c + rrs.substring(i);
				mr.add(val);
			}
		}

		return mr;
	}

}
