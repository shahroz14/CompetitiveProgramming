package hackerrank.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class PermutingTwoArrays {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for(int t=0; t<q; t++){
			int n = in.nextInt();
			int k = in.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			
			for(int i=0; i<n; i++)
				a[i] = in.nextInt();
			Arrays.sort(a);
			
			for (int i=0; i<n; i++)
				b[i] = in.nextInt();
			Arrays.sort(b);
			int i=0,j=0;
			for(i=0; i<n;i++){
				for( j=0; j<n; j++){
					if(b[i]+a[j]>=k){
						a[j] = 0;
						break;
					}
				}
				if(j==n){
					break;
				}
			}
			if(j==n){
				System.out.println("NO");
			}
			else
				System.out.println("YES");	
		}
	}
}
