public class JumpSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int pos = jumpSearch(new int[] {1,3,5,7,9,11,15,23,45,56,76},76);
		System.out.println(pos);
	}

	private static int jumpSearch(int[] is, int i) {

		int left = 0, right = (int)Math.sqrt(is.length);
		while(is[right]<i && right < is.length) {
			
			left = right;
			right += (int)Math.sqrt(is.length);
			
			if(right > is.length -1) {
				right = is.length-1;
			}
		}
		for(int j = left; j<=right;j++) {
			if(is[j] == i) 
				return j;
		}
		return -1;
	}

}
