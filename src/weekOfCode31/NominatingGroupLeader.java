package weekOfCode31;

import java.util.Scanner;

public class NominatingGroupLeader {
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for( int j=0; j<t; j++) {
			
			int n = in.nextInt();
			int[] arr = new int[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = in.nextInt();
			}
			
			
			int q = in.nextInt();
			
		l:	for(int k=0; k<q; k++) {
				
				int l = in.nextInt();
				int r = in.nextInt();
				int x = in.nextInt();
				
				int[] v = new int[n];
				
				for(int i=l; i<=r; i++){
					v[arr[i]]++;
				}
				
				for(int i=0; i<n; i++){
					if(v[i]==x){
						System.out.println(i);
						continue l;
					}
				}
				
				System.out.println("-1");
			}
			
			
		}
		
		
	}
	
	
}
