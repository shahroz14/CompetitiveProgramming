package hackerearth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Fight {
	
	
	
	public static void main(String[] args) {
		int[] fr = new int[1200000000];
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for(int j=0; j<t; j++) {
			int n = in.nextInt();
			long[] box = new long[n];
			
			for(int i=0; i<n; i++)
				box[i] = in.nextLong();
			
			Arrays.sort(box);
			long curr = 0;
			long maxCurr = 0;
			int currStr = 0;
			for(int i=0; i<n; i++){
				
				if(curr==box[i]){
					currStr++;
				}
				else {
					maxCurr = Math.max(currStr, maxCurr);
					currStr = 0;
				}
					
				curr = box[i];
				
			}
			maxCurr = Math.max(maxCurr, currStr);
			System.out.println(maxCurr+1);
			
		}
		
		
	}
	
	
}
