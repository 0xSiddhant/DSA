

public class Knapsack {

	public static void main(String[] args) {

		int wts[] = { 2, 2, 3, 1 };
		int price[] = { 5, 20, 100, 30 };
		int N = 4;
		int W = 5;
		System.out.println(knapsack(wts, price, N, W));
		
		System.out.println(knapsackBU(wts,price,N,W));
	}

	private static int knapsackBU(int[] wts, int[] price, int N, int W) {
		int dp[][] = new int[50][50];
		for(int n = 0;n<=N;n++) {
			for(int w = 0;w<=W;w++) {
				if(n ==0 || w == 0) {
					dp[n][w] = 0;
				}else {
					int inc = 0,exc = 0;
					
					if(wts[n-1]<=w) {
						inc = price[n-1]+ dp[n-1][w-wts[n-1]];
					}
					exc = dp[n-1][w];
					
					dp[n][w] = Math.max(inc, exc);
				}
			}
		}
		return dp[N][W];
	}
	

	private static int knapsack(int[] wts, int[] price, int n, int w) {
		if (n == 0 || w == 0)
			return 0;
		int inc = 0,exc = 0;
		if (wts[n - 1] <= w) {
			inc = price[n - 1] + knapsack(wts, price, n - 1, w - wts[n - 1]);
		}
		exc = 0 + knapsack(wts, price, n - 1, w);

		return Math.max(inc, exc);
	}
}
