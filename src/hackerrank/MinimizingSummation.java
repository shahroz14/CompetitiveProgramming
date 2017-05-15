package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizingSummation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] x = new int[n+1];
		long[] sum = new long[n+1];
		long[] sum2 = new long[n+1];
		
		for(int i=1; i<=n; i++)
			x[i] = in.nextInt();
		
		Arrays.sort(x);
		
		for(int i=1; i<=n; i++){
			sum[i] = sum[i-1]+x[i];
			sum2[i] = sum2[i-1]+(x[i]*x[i]);
		}
		//System.out.println(Arrays.toString(sum));
		//System.out.println(Arrays.toString(sum2));
		long min = Long.MAX_VALUE;
		long tempMin;
		for(int i=k; i<=n; i++){
			tempMin = (2*k*(sum2[i]-sum2[i-k]))-(2*(long) Math.pow(sum[i]-sum[i-k], 2));
			if(tempMin<min)
				min = tempMin;
		}
		
		System.out.println(min);
	}
}
