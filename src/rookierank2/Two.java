package rookierank2;

import java.util.Arrays;
import java.util.Scanner;

public class Two {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = in.nextInt();
		Arrays.sort(arr);
		long min = Long.MAX_VALUE;
		for(int i=0; i<n-1 ; i++)
			min = Math.min(min, Math.abs(arr[i]-arr[i+1]));
		System.out.println(min);
	}
}
