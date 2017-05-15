package hackerrank;

import java.util.Scanner;

public class Conjecture {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(conjecture(n));
		
	}
	
	static int conjecture(int n){
		int count = 0;
		while(true){
			if(n==1){
				count++;
				break;
			}
			if(n%2==0){
				n=n/2;
				count++;
			}
			else{
				n = 3*n+1;
				count++;
			}
		}
		return count;
	}
}
