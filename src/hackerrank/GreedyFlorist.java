package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyFlorist {
	/*
	 * https://www.hackerrank.com/challenges/greedy-florist
	 * All Domains  Algorithms  Greedy  Greedy Florist
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] c = new int[n+1];
		
		for(int i=1; i<=n; i++)
			c[i] = in.nextInt();
		int tc = 0;
		int times=1;
		int x = k;
		Arrays.sort(c);
		for(int i=n; i>0; i--){
			if(x<=0){
				x=k;
				times++;
			}
			tc += c[i]*times;
			x--;
		}
		System.out.println(tc);
	}
}
