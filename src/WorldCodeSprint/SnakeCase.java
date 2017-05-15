package WorldCodeSprint;

import java.util.Scanner;

public class SnakeCase {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int cnt = 0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='_')
				cnt++;
		}
		System.out.println(cnt+1);
	}
}
