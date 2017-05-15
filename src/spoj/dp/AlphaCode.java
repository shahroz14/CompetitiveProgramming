package spoj.dp;

import java.util.Scanner;

public class AlphaCode {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String st = in.next();
	l1:	while(!st.equals("0")){
			int n = st.length();
			int[] ar = new int[n];
			ar[0] = 1;
			if(n<2){
				System.out.println(ar[n-1]);
				st = in.next();
				continue;
			}
			
			if(canCombine(Integer.parseInt(st.substring(0,1)), Integer.parseInt(st.substring(1,2)))){
				ar[1] = 2;
			}
			else
				ar[1] = 1;
			for(int i=2; i<n; i++){
				if(st.charAt(i)=='0' && st.charAt(i-1)=='0'){
					System.out.println(0);
					st = in.next();
					continue l1;
				}
				
				else if(canCombine(Integer.parseInt(st.substring(i-1, i)), Integer.parseInt(st.substring(i, i+1)))){
					ar[i] = ar[i-1]+ar[i-2];
				}
				else
					ar[i] = 0;
			}
			System.out.println(ar[n-1]);
			st = in.next();
		}
	}
	
	public static boolean canCombine(int p, int n){
		
		if(p==1)
			if(n!=0)
				return true;
		
		if(p==2)
			if(n<=6 & n>0)
				return true;
		
		return false;
	}
}
