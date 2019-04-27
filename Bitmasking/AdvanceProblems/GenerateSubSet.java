package AdvanceProblems;

public class GenerateSubSet {

	public static void main(String[] args) {

		generate("ABC");
	}

	private static void generate(String str) {
		int n = str.length();
		int range = (1<<n);// 2^n - 1;
		for(int i=0;i<range;i++) {
			filterChar(str,i);
		}
	}

	private static void filterChar(String str, int no) {
		int index = 0;
		while(no>0) {
			if((no&1) == 1)
				System.out.print(str.charAt(index));
			no = no>>1;
			index++;
		}
		System.out.println();
	}

}
