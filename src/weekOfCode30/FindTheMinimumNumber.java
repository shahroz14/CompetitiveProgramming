package weekOfCode30;

import java.util.Scanner;

public class FindTheMinimumNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(getString(n));	
	}
	
	static String getString(int n){	
		if(n==1)
			return "int";
		return "min(int, "+getString(n-1)+")";
	}
}
