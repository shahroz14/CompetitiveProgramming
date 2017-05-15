package WeekOfCode28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SuffixRotation {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();
		for(int i=0; i<g; i++){
			String s = in.next();
			System.out.println(suffixRotation(s)-1);
		}
	}
	
	public static int suffixRotation(String s){
		
		if(isSmallest(s))
			return 1;
		int smallChar = getLeastAscii(s);
		while(s.charAt(0)==smallChar){
			for(int i=0; i<s.length(); i++){
				if(s.charAt(i)!=smallChar){
					s = s.substring(i, s.length());
					break;
				}
			}
		}
		//System.out.println(s);
		//System.out.println(getLeastAscii(s));
		smallChar = getLeastAscii(s);
		int n = s.length();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++){
			if(s.charAt(i)==smallChar){
				//System.out.println(suffixRotation(s.substring(i, n)+s.substring(0, i)));
				list.add(suffixRotation(s.substring(0, i))+1);
			}
		}
		Collections.sort(list);
		//System.out.println(list);
		return list.get(0);
	}
	
	public static boolean isSmallest(String s){
		for(int i=0; i<s.length()-1; i++){
			if(s.charAt(i)>s.charAt(i+1))
				return false;
		}
		return true;
	}
	
	public static int getLeastAscii(String s){
		int ascii = Integer.MAX_VALUE;
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if((int)c<ascii)
				ascii = (int)c;
		}
		return ascii;
	}
}
