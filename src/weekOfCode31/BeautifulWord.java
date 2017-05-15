package weekOfCode31;

import java.util.Scanner;

public class BeautifulWord {
	
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		String str = in.next();
		
		int n = str.length();
		
		boolean currVowel = false;
		
		for( int i=0; i<n-1; i++){
			
			char c = str.charAt(i);
			
			if(isVowel(c))
				currVowel = true;
			else
				currVowel = false;
			
			if(isVowel(str.charAt(i+1)) && currVowel || str.charAt(i)==str.charAt(i+1)) {
				System.out.println("No");
				return;
			}
				
			
		}
		
		System.out.println("Yes");
		
		
		
	}
	
	
	static boolean isVowel(char ch) {
		
		char[] c = {'a','e','i','o','u','y'};
		
		for (char d : c) {
			if(d==ch)
				return true;
		}
		
		return false;
	}
	
}
