package io;

import java.util.Scanner;

public class DigitSum{


	void solve() {
		int m;
		int n;
		Scanner in = new Scanner(System.in);
		m = in.nextInt();
		n = in.nextInt();
		while(m>0 && n>0){
			long sum = 0;
			for(int i=m; i<=n; i++)
				sum += getDigitSum(i);
			System.out.println(sum);
			m = in.nextInt();
			n = in.nextInt();
		}
		
	}
	
	int getDigitSum(int n){
		int sum = 0;
		int r;
		while(n>0){
			r = n%10;
			sum += r;
			n = n/10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		new DigitSum().solve();
	}
	
	
}
