package hackerearth;

import java.util.Arrays;
import java.util.Scanner;

public class SolitiaryString {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i=0; i<n; i++){
			
			String s = in.next();
			int len = s.length();
			int[] fo = new int[26];
			int[] lo = new int[26];
			
			Arrays.fill(fo, -1);
			Arrays.fill(lo, -1);
			
			for(int j=0; j<len; j++){	
				int ch = s.charAt(j)-97;
				
				if(fo[ch] == -1)
					fo[ch] = j;
				
				lo[ch] = j;
				
			}
			
			int res = -1;
			for (int k=0; k<26; k++) 
				res = Math.max(res, lo[k]-fo[k]-1);
			
			System.out.println(res);
			
		}
		
	}
}
