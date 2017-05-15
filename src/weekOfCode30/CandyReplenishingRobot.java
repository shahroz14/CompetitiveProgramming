package weekOfCode30;

import java.util.Scanner;

public class CandyReplenishingRobot {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int t = in.nextInt();
		int[] can = new int[t];
		
		for(int i=0; i<t; i++)
			can[i] = in.nextInt();
		
		int candies = 0;
		int currCand = n;
		
		for(int i=0; i<t-1; i++){
			currCand -= can[i];
			if(currCand < 5){
				candies += (n - currCand);
				currCand = n;
			}
		}
		
		System.out.println(candies);
	}
	
	
}
