package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {
	/*
	 * https://www.hackerrank.com/challenges/angry-children
	 * All Domains  Algorithms  Greedy  Max Min
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		for(int i=0; i<=n-k; i++){
			int temp = arr[k-1+i]-arr[i];
			if(temp<min)
				min = temp;
		}
		System.out.println(min);
	}
}
