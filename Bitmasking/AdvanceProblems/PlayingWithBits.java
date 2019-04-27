package AdvanceProblems;

public class PlayingWithBits {

	public static void main(String[] args) {

		maxBit(10,15);
	}

	private static void maxBit(int a, int b) {
		int ans = 0;
		for(int i = a;i<=b;i++) {
			if((i&1) == 0) {
				ans += 2 * countBit(i)+1;
				i++;
				continue;
			}
			ans += countBit(i)+1;
		}
		System.out.println(ans);
	}

	private static int countBit(int i) {
		int count=0;
		while(i>0) {
			if((i&1)==1) {
				count++;
			}
			i = i>>1;
		}
		return count;
	}

}
