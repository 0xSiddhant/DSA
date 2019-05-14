public class TernarySearch {

	public static void main(String[] args) {

		int pos = ternarySearch(new int[] {2,3,4,6,8,9,12,14,16,20,23},27);
		if(pos >= 0)
			System.out.println("Element found at index "+pos);
		else
			System.out.println("Element not found");
	}

	private static int ternarySearch(int[] is, int i) { 
			return ternarySearch(is,0,is.length,i);
	}

	private static int ternarySearch(int[] is, int left, int right, int val) {
		if(right - left>0) {
		int midFirst = left + (right-left)/3;
		int midSecond = midFirst + (right-left)/3;
		
		if(is[midFirst] == val)
			return midFirst;
		if(is[midSecond] == val)
			return midSecond;
		if(val < is[midFirst])
			return ternarySearch(is,left,midFirst,val);
		if(val >is[midSecond])
			return ternarySearch(is,midSecond+1,right,val);
	
			return ternarySearch(is,midFirst,midSecond,val);
		}else
			return -1;
	}
		

}
