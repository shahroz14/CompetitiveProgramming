package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.hackerrank.com/challenges/almost-sorted
 * All Domains  Algorithms  Implementation  Almost Sorted
 */

public class AlmostSorted {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int[] a = new int[n];
		String[] line = br.readLine().split(" ");
		
		for(int i=0; i<n;i++)
			a[i] = Integer.parseInt(line[i]);
		
		int[] sorted = Arrays.copyOf(a, n);
		Arrays.sort(sorted);
		if(Arrays.equals(a, sorted)){
			System.out.println("yes");
			return;
		}
		
		int l=0,r=0;
		boolean isMarked = false;
		for(int i=0; i<n-1; i++){
			if(a[i]>a[i+1]){
				if(!isMarked){
					isMarked = true;
					l = i;
				}
				r = i+1;
			}
		}
		
		swap(a,l,r);
		if(Arrays.equals(a, sorted)){
			System.out.println("yes");
			System.out.println("swap "+(l+1)+" "+(r+1));
			return;
		}
		swap(a,l,r);
		reverse(a,l,r);
		if(Arrays.equals(a, sorted)){
			System.out.println("yes");
			System.out.println("reverse "+(l+1)+" "+(r+1));
			return;
		}
		System.out.println("no");
	}

	private static void reverse(int[] a, int l, int r) {
		int[] s = new int[r-l+1];
		for(int i=l; i<=r; i++){
			s[i-l] = a[i];
		}
		for(int i=l; i<=r; i++){
			a[i] = s[r-i];
		}
	}

	private static void swap(int[] a, int l, int r) {
		int temp = a[l];
		a[l] = a[r];
		a[r] = temp;
	}
	
}
