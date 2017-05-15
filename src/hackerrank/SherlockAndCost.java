package hackerrank;

import java.util.Scanner;

public class SherlockAndCost {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t= in.nextInt();
		for(int i=0; i<t; i++){
			int n = in.nextInt();
			int[] a = new int[n];
			
			for(int j=0; j<n; j++)
				a[j] = in.nextInt();
			
			
			if(n<2){
				System.out.println("0");
				continue;
			}
			int[][] dp = new int[100005][2];
			
			for(int k=0; k<n;k++){
				if(k%2==0){
					dp[k][0] = a[k];
					dp[k][1] = 1;
				}
				else{
					dp[k][0] = 1;
					dp[k][1] = a[k];
				}
			}
			
			int sum1=0;
			int sum2=0;
			for(int k=0; k<n-1; k++){
				sum1 += Math.abs(dp[k+1][0]-dp[k][0]);
				sum2 += Math.abs(dp[k+1][1]-dp[k][1]);
			}
			System.out.println(Math.max(sum1, sum2));
		}
	}
	
}
