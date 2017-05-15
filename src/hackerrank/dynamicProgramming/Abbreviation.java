package hackerrank.dynamicProgramming;

import java.util.Scanner;

public class Abbreviation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = 'a';
		int K = 'A';
		System.out.println(Math.abs(k-K));
		int t = in.nextInt();
		for(int test=0; test<t; test++){
			String a = in.next();
			String b = in.next();
			int n = a.length();
			int m = b.length();
			
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					if(Math.abs((int)(a.charAt(i))-(int)(b.charAt(j)))!=32){
						
					}
				}
			}
			
			
		}
	}
}
