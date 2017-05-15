package WeekOfCode28;

import java.util.Scanner;

public class BoatTrips {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c = in.nextInt();
		int m = in.nextInt();
		int cap = c*m;
		
		
		for(int i=0; i<n; i++){
			if(in.nextInt()>cap){
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}
}
