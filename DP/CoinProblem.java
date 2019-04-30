

import java.util.Arrays;

public class CoinProblem {

	public static void main(String[] args) {

		int coins[] = {1,2,5,10};
		int amount = 39;
		// TopDown Approach
		System.out.println(coinNeededTD(coins,amount,coins.length));
		
		// BottomUp Approach'
		System.out.println(coinNeededBU(coins,amount,coins.length));
	}

	private static int coinNeededBU(int[] coins, int amount, int length) {
		
		int dp[] = new int[amount+1];
		Arrays.fill(dp, 1000);
		dp[0] = 0;
		
		// Amount loop
		for(int rupay = 1;rupay<=amount;rupay++) {
			//coin loop
			for(int i=0;i<length;i++) {
				if(coins[i]<= rupay) {
					int smallans = dp[rupay-coins[i]];
					if(smallans!= 1000) {
						dp[rupay] = Math.min(dp[rupay], smallans+1);
					}
				}
			}
		}
		
		return dp[amount];
	}

	private static int coinNeededTD(int[] coins, int amount, int length) {

		int dp[] = new int[amount+1];
		Arrays.fill(dp, 1000);
		return coinNeeded(coins,amount,length,dp);
	}

	private static int coinNeeded(int[] coins, int amount, int length, int[] dp) {

		if(amount == 0) {
			dp[amount] = 0;
			return 0;
		}
		if(dp[amount] != 1000) {
			return dp[amount];
		}
		for(int i = 0;i<length;i++) {
			if(amount - coins[i]>=0) {
				int smallans = coinNeeded(coins,amount-coins[i],length,dp);
				dp[amount] = Math.min(dp[amount], smallans+1);
			}
		}
		return dp[amount];
	}

}
