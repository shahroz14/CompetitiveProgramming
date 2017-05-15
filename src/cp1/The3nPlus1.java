package cp1;

import java.util.Scanner;

public class The3nPlus1 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		
		long max = Long.MIN_VALUE;
		for(int i=a; i<=b; i++)
			max = Math.max(max, f(i));
		System.out.println(max);
		
	
	}
	
	static long f(int a) {
		long count = 1;
		
		while(a!=1){
			if(a%2==0){
				a = a/2;
				count++;
			}
			else {
				count++;
				a = 3*a+1;
			}
		}
		
		return count;
	}
	
}
