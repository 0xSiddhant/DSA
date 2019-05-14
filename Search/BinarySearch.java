public class BinarySearch {

	public static void main(String[] args) {

		int pos = binarySearch(new int[] {1,3,4,5,6,7,9,12,14,20,32,34,45,67},98);
		if((pos == -1)) {
			System.out.println("Element not fount");
		}else
			System.out.println("Element found at index "+pos);
		
		lowerbound(new int[] {1,2,2,2,2,4,4},2);
		upperbound(new int[] {1,2,2,2,2,4,4},2);
	}

	private static void lowerbound(int[] is, int i) {
		int pos = lowerbound(is,0,is.length-1,i);
		if(pos == -1)
			System.out.println("Element not found");
		else
			System.out.println("Element lower index is "+pos);
	}

	private static int lowerbound(int[] is, int s, int end, int search) {
		int ans = -1;
		while(s<=end) {
			int mid = (s+end)/2;
			if(search == is[mid]) {
				ans = mid;
				end = mid-1;
			}
			else if(search >is[mid]) {
				s = mid +1;
			}
			else if(search <is[mid])
				end = mid-1;
		}
		return ans;
		
	}
	
	private static void upperbound(int[] is, int i) {
		int pos = upperbound(is,0,is.length-1,i);
		if(pos == -1)
			System.out.println("Element not found");
		else
			System.out.println("Element Upper index is "+pos);
	}

	private static int upperbound(int[] is, int s, int end, int search) {
		int ans = -1;
		while(s<=end) {
			int mid = (s+end)/2;
			if(search == is[mid]) {
				ans = mid;
				s = mid+1;
			}
			else if(search >is[mid]) {
				s = mid +1;
			}
			else if(search <is[mid])
				end = mid-1;
		}
		return ans;
		
	}

	private static int binarySearch(int[] is, int i) {
		int beg=0, end=is.length-1,mid;
		while(beg<=end) {
			mid = (beg + end)/2;
			if(is[mid] == i)
				return mid;
			else if(is[mid]>i)
				end = mid-1;
			else
				beg = mid +1;
		}
		return -1;
	}

}
