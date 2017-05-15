package rookierank2;

import java.util.Scanner;

public class Three {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		char[] hack = {'h', 'a', 'c', 'k', 'e', 'r', 'r', 'a', 'n', 'k'};
		for(int i=0; i<n; i++){
			String s = in.next();
			int l = s.length();
			int p = 0;
			for(int j=0; j<l; j++){
				if(s.charAt(j)==hack[p])
					p++;
				if(p>8)
					break;
			}
			if(p>8)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
