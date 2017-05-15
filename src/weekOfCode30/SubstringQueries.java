package weekOfCode30;

import java.util.HashMap;
import java.util.Scanner;



public class SubstringQueries {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		String[] str = new String[n];
		for(int i=0; i<n; i++){
			str[i] = in.next();
		}
		for(int i=0; i<q; i++){
			
			int x = in.nextInt();
			int y = in.nextInt();
			if(x<y){
				if(map.containsKey(x+", "+y)){
					System.out.println(map.get(x+", "+y));
					continue;
				}
				else if(map.containsKey(y+", "+x)){
					System.out.println(map.get(y+", "+x));
					continue;
				}
			}
			
			String a = str[x];
			String b = str[y];
			int lenA = a.length();
			boolean ch = false;
	l1:		for( int j=lenA; j>0; j--){
				for( int k=0; k<=(lenA-j); k++){
					String tmp = a.substring(k,k+j);
					if(match( b, tmp)!=-1){
						ch = true;
						if(x<y)
							map.put(x+", "+y, tmp.length());
						else
							map.put(y+", "+x, tmp.length());
						System.out.println(tmp.length());
						break l1;
					}
				}
			}
			if(!ch)
				System.out.println(0);
		}
		
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
