package januaryCircuits;

import java.util.Scanner;

public class GoodString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int n = s.length();
		int[] cnt = new int[26];
		
		for(int i=0; i<n; i++)
			cnt[s.charAt(i)-97]++;
		
		int ans = 0;
		for(int i=0; i<cnt.length; i++){
			if(cnt[i]!=0)
				ans += cnt[i]-1;
		}
		System.out.println(ans);
	}
}
