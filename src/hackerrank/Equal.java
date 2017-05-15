package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class Equal {
	/*
	 * https://www.hackerrank.com/challenges/equal *****
	 * All Domains  Algorithms  Dynamic Programming  Equal
	 * 
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0; i<t; i++){
			int n = in.nextInt();
			int[] choco = new int[n];
			for(int j=0; j<n;j++)
				choco[j] = in.nextInt();
			
			Arrays.sort(choco);
			int min = choco[0];
			int op=0;
			for(int j=0; j<n; j++){
				if(choco[j]>min){
					int k = choco[j]-min;
					op += (k/5)+(k%5)/2 + (k%5)%2;
				}
			}
			int op1 = 0;
			for(int j=0; j<n; j++){
				if(choco[j]>0){
					int k = choco[j];
					op1 += (k/5)+(k%5)/2 + (k%5)%2;
				}
			}
			System.out.println(Math.min(op, op1));
		}
	}
}
