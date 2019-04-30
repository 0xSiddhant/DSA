public class LadderProblem {

	public static void main(String[] args) {

		System.out.println(ways(5,3));
	}

	// This method is topdown approach of dynamic problem
	private static int ways(int n, int k) {
		int arr[] = new int[n+1];
		return waysTD(n,k,arr);
	}

	private static int waysTD(int n, int k, int[] arr) {

		if(n == 0) {
			arr[n] = 1;
			return arr[n];
		}
		if(n<0) {
			return 0;
		}
		if(arr[n] != 0)
			return arr[n];
		else {
			for(int i =1;i<=k;i++) {
				arr[n] += waysTD(n-i,k,arr);
			}
			return arr[n];
		}
	}

}
