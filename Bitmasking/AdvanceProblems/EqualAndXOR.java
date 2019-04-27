package AdvanceProblems;

public class EqualAndXOR {

	public static void main(String[] args) {
		sumXor(10);
		sumXorFAST(10);
	}

	
	/* 
	 * 
	 * This method work in O(log n) times.
	 */
	private static void sumXorFAST(int i) {

			int unsetBit = 0;
			while(i>0) {
				if((i&1) == 0) 
					unsetBit++;
				i = i>>1;
			}
			System.out.println(1<<unsetBit);
	}


	/* this method take O(n) time to compute
	 * 
	 */
	private static void sumXor(long n) {
		long t=0;
		for(long i =0;i<n;i++) {
			if((i+n) == (i^n))
				t++;
		}
		System.out.println(t);
	}

}
