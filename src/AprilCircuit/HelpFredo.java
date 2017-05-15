package AprilCircuit;

import java.util.Scanner;

public class HelpFredo {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		double[] arr = new double[n];
		double gm = 1.0d;
		
		for(int i=0; i<n; i++) {
			
			arr[i] = in.nextDouble();
			gm *= Math.pow(arr[i], 1.0d/n);
			
		}
		
		if(Math.ceil(gm)==gm)
			System.out.println((int)gm+1);
		else
			System.out.println((int)Math.ceil(gm));
		
		
		
		
		
		
	}
}
