package WeekOfCode28;

import java.util.Scanner;

public class LuckyNumberEight {
	public static void main(String[] args) {
		int mod = 1000000007;

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		String str = in.next();
		for(int i=0; i<n; i++)
			arr[i] = (Integer.parseInt(str.substring(i, i+1))%8);
		luckyNumber(arr,mod);
		
	}
	
	public static void luckyNumber(int[] arr, int mod){
		int n = arr.length;
		long[][] dp = new long[n][8];
		int[][] lookUp = {
				{0,-1,3,-1,2,-1,1,-1},
				{-1,0,-1,3,-1,2,-1,1},
				{1,-1,0,-1,3,-1,2,-1},
				{-1,1,-1,0,-1,3,-1,2},
				{2,-1,1,-1,0,-1,3,-1},
				{-1,2,-1,1,-1,0,-1,3},
				{3,-1,2,-1,1,-1,0,-1},
				{-1,3,-1,2,-1,1,-1,0},
		};
		dp[0][arr[0]] = 1;
		for(int i=1; i<n; i++){
			for(int j=0; j<8; j++){
				if(arr[i]==j){
					if(j==0||j==4)
						dp[i][j] = (1 + 2*dp[i-1][j] + dp[i-1][(j+4)%8])%mod;
					else
						dp[i][j] = (dp[i-1][j]+dp[i-1][0]+dp[i-1][4]+1)%mod;
				}
					
				else{
					if(lookUp[j][arr[i]]>=0){
						dp[i][j] = (dp[i-1][j]+dp[i-1][lookUp[j][arr[i]]]+dp[i-1][(lookUp[j][arr[i]]+4)%8])%mod;
					}
					else
						dp[i][j] = dp[i-1][j]%mod;
				}	
			}
		}
		
		printDp(dp, n);
		System.out.println(dp[n-1][0]);
	}
	
	public static void printDp(long[][] dp, int n){
		for(int i=0; i<n; i++){
			for(int j=0; j<8; j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
