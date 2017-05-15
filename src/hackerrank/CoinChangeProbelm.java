package hackerrank;

import java.util.Scanner;

public class CoinChangeProbelm {
	
	/*
	 * 
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] coins = new int[m];
		
		for(int i=0; i<m; i++)
			coins[i] = in.nextInt();
		
		System.out.println(coinChange(coins, m, n));
		
	}
	
	private static long coinChange(int[] coins, int n, int sum) {
		long[][] dp = new long[n+1][sum+1];
		for(int i=1; i<=n; i++)
			dp[i][0] = 1;
		for(int i=0; i<=sum; i++)
			dp[0][i] = 0;
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=sum; j++){
				if(j-coins[i-1]<0)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
			}
		}
		return dp[n][sum];
	}
}
