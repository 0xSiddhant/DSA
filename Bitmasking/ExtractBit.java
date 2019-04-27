
public class ExtractBit {

	public static void main(String[] args) {
		System.out.println(extractIthBit(13,1));
		System.out.println(extractIthBit(13,2));
		System.out.println(extractIthBit(13,3));
	}

	private static int extractIthBit(int no, int i) {
		return (no & (1<<i))!= 0 ?1:0;
	}
	
	
}
