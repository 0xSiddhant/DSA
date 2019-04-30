public class LCS {

	public static long start;
	public static long end;

	public static void startAlgo() {
		start = System.currentTimeMillis();
	}

	public static long endAlgo() {
		end = System.currentTimeMillis();
		return end - start;
	}

	public static void main(String[] args) {
		System.out.println(lcs("abbg", "agbg"));
		System.out.println(lcs("abbg", "agbg"));
		String str1 = "abbgjdjdsjvjsisjskjscscs", str2 = "agbgcncjscskcjssjss";
		startAlgo();
		System.out.println(lcs(str1, str2));

		System.out.println("lcs Normal took time " + endAlgo() + " ms ");

		startAlgo();
		System.out.println(lcsI(str1, str2));
		System.out.println("lcs Iterative took time " + endAlgo() + " ms ");
	}

	public static int lcs(String str1, String str2) {

		/// Complexity of this algorithm is === 2^(str1.length + str2.length);
		if (str1.length() == 0 || str2.length() == 0)
			return 0;

		int count = 0;
		if (str1.charAt(0) == str2.charAt(0)) {
			count = 1 + lcs(str1.substring(1), str2.substring(1));
		} else {
			int f1 = lcs(str1.substring(1), str2);
			int f2 = lcs(str1, str2.substring(1));
			count = Math.max(f1, f2);
		}
		return count;
	}

	public static int lcsI(String str1, String str2) {
		// Complexity of this algorithm ========== str1.length * str2.length
		int[][] strg = new int[str1.length() + 1][str2.length() + 1];

		// seed
		strg[str1.length()][str2.length()] = 0;

		for (int i = str1.length(); i >= 0; i--) {
			for (int j = str2.length(); j >= 0; j--) {
				if (i == str1.length() || j == str2.length()) {
					strg[i][j] = 0;
					continue;
				}
				if (str1.charAt(i) == str2.charAt(j)) {
					strg[i][j] = 1 + strg[i + 1][j + 1];
				} else {
					strg[i][j] = Math.max(strg[i + 1][j], strg[i][j + 1]);
				}
			}
		}

		return strg[0][0];
	}

}
