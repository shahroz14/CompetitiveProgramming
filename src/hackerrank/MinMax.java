package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class MinMax {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] arr = new int[5];
		for(int i=0; i<5; i++)
			arr[i] = in.nextInt();
		Arrays.sort(arr);
		long min=0, max=0;
		for(int i=0; i<4; i++)
			min += arr[i];
		for(int i=1; i<5; i++)
			max += arr[i];
		System.out.println(min+" "+max);
			
	}
}
