package hackerrank.dynamicProgramming;

import java.util.Scanner;

public class SherlockCost {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0; i<t;i++){
			int n = in.nextInt();
			int[] ar = new int[n];
			
			for(int j=0; j<n; j++){
				ar[j] = in.nextInt();
			}
			int[][] dp = new int[n][2];
			for(int j=0;j<n-1;j++){
				dp[j+1][0] = Math.max(dp[j][0], dp[j][1]+ar[j]-1);
				dp[j+1][1] = Math.max(dp[j][0]+ar[j+1]-1, dp[j][1]+ar[j+1]-ar[j]);
			}
			System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
		}
	}
}
