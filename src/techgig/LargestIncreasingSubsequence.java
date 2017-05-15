package techgig;

import java.util.HashMap;
import java.util.Scanner;

public class LargestIncreasingSubsequence {
	
	static String s = null;
	static HashMap<String, String> map;
	public static void main(String[] args) {
		//System.out.println("aaba".compareTo("aac"));
		Scanner in = new Scanner(System.in);
		s = in.next();
		map = new HashMap<String, String>();
		System.out.println(f("", 0, s.length()-1));
	}
	
	
	static String f(String pre, int i, int n){
		//System.out.println(pre);
		int pl = pre.length()-1;
		if(i>n)
			return pre;
		
		if(pl<0){
			String s1 = f(pre+s.charAt(i), i+1, n);
			String s2 = f(pre, i+1, n);
			if(s1.length()>s2.length()){
				
				return s1;
			}
			else if(s1.length()<s2.length())
				return s2;
			else{
				if(s1.compareTo(s2)>0)
					return s2;
				else
					return s1;
			}
		}
		else if(pre.charAt(pl)<=s.charAt(i)){
			String s1 = f(pre+s.charAt(i), i+1, n);
			String s2 = f(pre, i+1, n);
			if(s1.length()>s2.length()){
				return s1;
			}
			else if(s1.length()<s2.length())
				return s2;
			else{
				if(s1.compareTo(s2)>0)
					return s2;
				else
					return s1;
			}
			
		}
		return pre;
	}
}
