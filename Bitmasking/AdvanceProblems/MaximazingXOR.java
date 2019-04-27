package AdvanceProblems;

public class MaximazingXOR {

	/*
	 * This is hackerRank Problem;
	 * https://www.hackerrank.com/challenges/maximizing-xor/problem
	 */
	public static void main(String[] args) {
		System.out.println(maximizingXor(10, 15));
		System.out.println(maximizingXor(11, 12));
		System.out.println(maximizingXor(11, 100));

	}
	static int maximizingXor(int l, int r) {
        int maxXor = 0;
        for(int i = l;i<=r;i++){
            for(int j = l;j<=r;j++){
               int currXor = i ^j;
                if(currXor>maxXor){
                    maxXor = currXor;
                }
            }
        }
        return maxXor;
    }

}
