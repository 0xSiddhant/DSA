
public class uniqueNo1 {

	public static void main(String[] args) {
		unique_no1(new int[] {2,3,4,8,4,3,2,5,6,7,6,7,5});
		unique_no1(new int[] {5,2,6,9,2,5,6});
	}

	private static void unique_no1(int[] is) {
		int ans = 0;
		for(int i =0;i<is.length;i++) {
			ans = ans ^ is[i];
		}
		System.out.println(ans);
	}

}
