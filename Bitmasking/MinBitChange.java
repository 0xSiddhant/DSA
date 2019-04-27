
public class MinBitChange {

	/* Suppose a and b is given. find min no. of bits that is need to change to convert a into b.
	 * 
	 */
	public static void main(String[] args) {
		bitChange(11,15);
		bitChange(2, 15);
	
	}

	private static void bitChange(int i, int j) {

		int ans = i ^j,check = 0;
		while(ans>0) {
			check += (ans&1);
			ans= ans>>1;
		}
		System.out.println(check);
	}

}
