package hackerrank;


import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/larrys-array
 * All Domains > Algorithms > Implementation > Larry's Array
 */
public class LarryArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0; i<t; i++){
			int n = in.nextInt();
			int[] a = new int[n];
			
			for(int j=0;j<n; j++){
				a[j] = in.nextInt();
			}
			
			for(int j=0; j<n-2; j++){
				for(int k=0; k<n-j-2; k++){
					
					if(isRightAtMax(a, k, k+1, k+2))
						continue;
					rotate(a, k, k+1, k+2);
					if(isRightAtMax(a, k, k+1, k+2))
						continue;
					rotate(a, k, k+1, k+2);
					if(isRightAtMax(a, k, k+1, k+2))
						continue;
					
				}
			}
			
			if(a[0]==1)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	
	static void rotate(int[] a, int x, int y, int z){
		int temp = a[x];
		a[x] = a[y];
		a[y] = a[z];
		a[z] = temp;
	}
	
	static boolean isRightAtMax(int[] a, int x, int y, int z){
		int max = getMax(a[x], a[y], a[z]);
		if(a[z]==max)
			return true;
		return false;
			
		
	}
	
	static int getMax(int a, int b, int c){
		return Math.max(a, Math.max(b, c));
	}
	
	
	
}
