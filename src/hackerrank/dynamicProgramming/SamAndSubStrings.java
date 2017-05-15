package hackerrank.dynamicProgramming;

import java.util.Scanner;

public class SamAndSubStrings {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int mod = 1000000007;
		String str = in.next();
		int n = str.length();
		long[] sd = new long[n];
		sd[0] = Integer.parseInt(str.substring(0, 1))%mod;
		for(int i=1; i<n; i++){
			sd[i] = ((Long.parseLong(str.substring(i, i+1))*(i+1))%mod + (10*sd[i-1])%mod)%mod;
		}
		long ans = 0l;
		for(int i=0; i<n; i++){
			ans = (ans + sd[i])%mod;
		}
		System.out.println(ans);
	}
}
