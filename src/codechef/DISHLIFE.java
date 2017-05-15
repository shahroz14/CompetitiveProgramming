package codechef;
import java.util.HashSet;
import java.util.Scanner;

public class DISHLIFE {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String inp = in.nextLine();
		int t = Integer.parseInt(inp);
		HashSet<Integer> ingdNeed = new HashSet<Integer>();
		StringBuilder ans = new StringBuilder();
		
	tc:	for(int j=0; j<t; j++) {
			
			String[] input = in.nextLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			
			
			
			for(int i=1; i<=k; i++)
				ingdNeed.add(i);
			
			
			for( int i=0; i<n; i++) {
				
				String[] ingds = in.nextLine().split(" ");
				
				for( int l=0; l<ingds.length; l++) {
					
					int ing = Integer.parseInt(ingds[l].trim());
					
					if(ingdNeed.contains(ing))
							ingdNeed.remove(ing);
					
				}
				
				if(ingdNeed.isEmpty() && i!= n-1) {
					ans.append("some\n");
					continue tc;
				}
				
			}
			
			if(ingdNeed.isEmpty())
				ans.append("all\n");
			else
				ans.append("sad\n");
			
			ingdNeed.clear();
		}
			
		System.out.println(ans);
	}
}
