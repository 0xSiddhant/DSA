
/*
 * Magic no. is a no. which is power of 5 or sum of unique power of 5.
 * eg = > 5, 25 , 30 (25 + 5),....
 */
public class MagicNo {

	public static void main(String[] args) {
		//magicNO(2);
		for(int i=1 ;i<11;i++) {
			magicNO(i);
		}
	}

	private static void magicNO(int n) {

		int ans = 0,pos=1;
		while(n>0) {
			if((n & 1) == 1) {
				ans += Math.pow(5,pos);
			}
			pos++;
			n = n>>1;
		}
		System.out.println(ans);
	}

}
