
public class SetBit {

	public static void main(String[] args) {
		
		setIthBit(13,1);
		setIthBit(8,2);
	}

	private static void setIthBit(int no, int i) {
		int mask = 1<<i;
		System.out.println(no | mask);
	}

}
