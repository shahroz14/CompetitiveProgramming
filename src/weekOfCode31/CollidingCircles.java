package weekOfCode31;

import java.util.Scanner;

public class CollidingCircles {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		
		int[] arr = new int[n];
		double sum = 0;
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
			sum += arr[i];
		}
		
		
		if(k == n-1) {
			
			System.out.println(Math.PI*(Math.pow(sum, 2)));
			
		}
		else{
			System.out.println("I don't Know");
			return;
		}
			
		
	}
	
	
}
