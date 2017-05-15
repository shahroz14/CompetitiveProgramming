package codeforces;

import java.util.Scanner;

public class UncommonSubsequence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		int al = a.length();
		int bl = b.length();
		int maxL = Math.max(al, bl);
		if(maxL==bl){
			if(a.equals(b))
				System.out.println("-1");
			else
				System.out.println(bl);
			return;
		}
		else if(maxL==al){
			if(a.equals(b))
				System.out.println("-1");
			else
				System.out.println(al);
			return;
		}
	}
}
