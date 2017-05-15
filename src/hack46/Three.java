package hack46;

import java.util.HashMap;
import java.util.Scanner;

public class Three {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		String[] genes = new String[n];
		long[] health = new long[n];
		
		for(int i=0; i<n; i++){
			genes[i] = in.next();
		}
		
		HashMap<String, Long> healthMap = new HashMap<String, Long>();
		
		for(int i=0; i<n; i++){
			long h = in.nextLong();
			health[i] = h;
			healthMap.put(genes[i], h);
		}
		
		long maxHealth = Long.MIN_VALUE;
		long minHealth = Long.MAX_VALUE;
		
		int k = in.nextInt();
		
		
		for(int i=0; i<k; i++){
			
			int a = in.nextInt();
			int b = in.nextInt();
			
			String strand = in.next();
			int tempHealth = 0;
			
			for(int j=a; j<=b; j++){
				int mInd = match(strand, genes[j]);
				
				if(mInd >= 0)
					tempHealth += healthMap.get(genes[j]);
				
			}
			
			maxHealth = Math.max(maxHealth, tempHealth);
			minHealth = Math.min(minHealth, tempHealth);
			
		}
		
		System.out.println(minHealth+" "+maxHealth);
		
	}
	
	
	public static int[] getPrefixArray(String pat){
		int j=0, n=pat.length();
		int[] prefix = new int[n];
		prefix[0] = 0;
		for(int i=1; i<n; i++){
			if(pat.charAt(i)==pat.charAt(j)){
				prefix[i] = j+1;
				j++;
			}
			else{
				if(j==0)
					prefix[i] = 0;
				else{
					j = prefix[j-1];
					i--;
				}
			}
		}
		return prefix;
	}
	
	public static int match(String text, String pat){
		int j=0, i=0, n=text.length();
		int[] pre = getPrefixArray(pat);
		for(i=0; i<n; i++){
			if(j==pat.length())
				return i-pat.length();
			if(text.charAt(i)==pat.charAt(j)){
				j++;
			}
			else{
				if(j>0){
					j=pre[j-1];
					i--;
				}
				else
					j=0;
			}
		}
		if(j==pat.length())
			return i-pat.length();
		return -1;
	}
	
}
