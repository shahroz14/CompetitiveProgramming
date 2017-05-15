package weekOfCode31;

import java.util.Scanner;

public class CollidingCrilces {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int[] radii = new int[n];
		
		long[] pre = new long[n];
		long[] suf = new long[n];
		
		for( int i=0; i<n; i++) 
			radii[i] = in.nextInt();
			
		pre[0] = radii[0]*radii[0];
		suf[n] = radii[n]*radii[n];
		
		for(int i=1; i<n; i++)
			pre[i] = pre[i-1]+radii[i]*radii[i];
		
		for(int i=n-2; i>=0; i--)
			suf[i] = suf[i+1]+radii[i]*radii[i];
		
		
		int toLeft = n-1-k;
		
		
		
		
	}
}	
