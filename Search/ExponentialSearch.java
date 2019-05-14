import java.util.Arrays;

public class ExponentialSearch {

	public static void main(String[] args) {

		int pos = exponentialSearch(new int[] {2,3,4,6,8,9,12,14,16,20,23},92);
		if(pos >= 0)
			System.out.println("Element found at index "+pos);
		else
			System.out.println("Element not found");
	}

	private static int exponentialSearch(int[] is, int i) {

		if(is[0] == i)
			return 0;
		
		int j = 1;
		while(j<is.length && is[j] <= i)
			j *= 2;
		
		return Arrays.binarySearch(is, j/2, Math.min(j, is.length), i);
	}

}
