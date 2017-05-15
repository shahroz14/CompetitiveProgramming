package codechef;

import java.util.HashSet;
import java.util.Scanner;

public class SIMDISH {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		HashSet<String> set = new HashSet<String>();
		StringBuilder ans = new StringBuilder();
		for( int j=0; j<t; j++) {
			
			String[] d1 = in.nextLine().split(" ");
			
			for(int i=0; i<d1.length; i++)
				set.add(d1[i]);
	
			String[] d2 = in.nextLine().split(" ");
			int cnt = 0;
			for(int i=0; i<d2.length; i++)
				if(set.contains(d2[i]))
					cnt++;
			if(cnt >=2)
				ans.append("similar\n");
			else
				ans.append("dissimilar\n");
			set.clear();
		}
		System.out.println(ans);
	}
	
	
}
