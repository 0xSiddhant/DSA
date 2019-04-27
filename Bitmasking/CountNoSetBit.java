
public class CountNoSetBit {
	public static void main(String[] args) {
		countSetBit(15);
		countSetBit(17);
		countSetBitFast(15);
		countSetBitFast(74);
	}

	private static void countSetBitFast(int n) {
		/*
		 * This algorithm is called BRIAN KERNIGHAN'S ALGORITHM
		 * O(log n)
		 */
		int count = 0;
		while(n>0) {
			count++;
			n = n & (n-1);
		}
		System.out.println(count);
	}

	private static void countSetBit(int i) {
		int ans = 0;
		while(i>0) {
			ans += (i&1);
			i = i>>1;
		}
		System.out.println(ans);
	}
}
