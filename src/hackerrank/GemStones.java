package hackerrank;

import java.util.Scanner;

public class GemStones {
	/*
	 * https://www.hackerrank.com/challenges/gem-stones
	 * All Domains  Algorithms  Strings  Gemstones
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] cnt = new int[26];
		for(int i=0; i<n; i++){
			
			String comp = in.next();
			boolean[] ele = new boolean[26];
			
			for(int j=0; j<comp.length(); j++){
				ele[comp.charAt(j)-97] = true;
			}
			
			for(int j=0; j<26; j++){
				if(ele[j])
					cnt[j]++;
			}
		}
		int gem = 0;
		for(int i=0; i<26; i++){
			if(cnt[i]==n)
				gem++;
		}
		System.out.println(gem);
	}

}
