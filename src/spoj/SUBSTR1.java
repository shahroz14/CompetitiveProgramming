package spoj;

import java.util.Scanner;

public class SUBSTR1 {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = 24;
		
		for(int i=0; i<n; i++){
			String a = in.next();
			String b = in.next();
			if(isSubstring(a, b))
				System.out.println("1");
			else
				System.out.println("0");
		}
		
	}
	
	
	static boolean isSubstring(String a, String b) {
		
		int bLen = b.length();
		int aLen = a.length();
		
		for(int i=0; i<=aLen-bLen; i++) {
			
			if(a.substring(i, i+bLen).equals(b))
				return true;
			
		}
		
		return false;
		
	}
	
	
}
