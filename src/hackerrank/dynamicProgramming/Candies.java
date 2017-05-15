package hackerrank.dynamicProgramming;


import java.util.Arrays;
import java.util.Scanner;

public class Candies {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] rating = new int[n];
		int[] candies = new int[n];
		
		
		for(int i=0; i<n; i++){
			rating[i] = in.nextInt();
			candies[i] = 1;
		}
	
		
		for(int i=1; i<n; i++){
			if(rating[i-1]<rating[i])
				candies[i] = candies[i-1]+1;
		}
		
		
		for(int i=n-2; i>=0; i--){
			if(rating[i]>rating[i+1])
				candies[i] = Math.max(candies[i], candies[i+1]+1);
		}
		long cand=0;
		for(int i=0; i<n; i++){
			cand += candies[i];
		}
			
		System.out.println(cand);
		

	}
}
