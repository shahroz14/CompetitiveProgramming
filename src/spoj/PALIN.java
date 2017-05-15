package spoj;

import java.util.Scanner;

public class PALIN {
	
	public static void main(String[] args) {
		
		Scanner in =  new Scanner(System.in);
		int t = in.nextInt();
		
		for(int i=0; i<t; i++){
			String s = in.next();
		}
		
	}
	
	@Deprecated
	static String getSmallestPalindrome(String s){
		
		StringBuilder sb = new StringBuilder(s);
		int n = s.length();
		
		for(int i=0; i<n/2; i++) {
			
			int l = Integer.parseInt(s.charAt(i)+"");
			int r = Integer.parseInt(s.charAt(n-i-1)+"");
			if(l==r)
				continue;
			
			if(l<r) {
				sb.replace(n-i-1, n-i, sb.charAt(i)+"");
				r = l;
				
			}
			
		}
		return sb.toString();
	}
	
}


