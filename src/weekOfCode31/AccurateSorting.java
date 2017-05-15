package weekOfCode31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AccurateSorting {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String iQ = br.readLine();
		int q = Integer.parseInt(iQ.trim());
		
		for( int a=0; a<q; a++) {
			
			String arrSize = br.readLine();
			int[] arr = new int[Integer.parseInt(arrSize.trim())];
			String[] arrInp = br.readLine().split(" ");
			
			for(int i=0; i<arr.length; i++)
				arr[i] = Integer.parseInt(arrInp[i].trim());
		
			sort(arr);
			
			if(isSorted(arr))
				System.out.println("Yes");
			
			else
				System.out.println("No");
			
		
		}
		
	}
	
	static void sort(int[] a) {
		
		int n = a.length;
		
		for(int i=0; i<n-1; i++) {
			
			if( Math.abs(a[i]-a[i+1])== 1 && a[i]>a[i+1]) {
				int temp = a[i+1];
				a[i+1] = a[i];
				a[i] = temp;
			}
			
		}
		
	}
	
	static boolean isSorted(int[] a) {
		
		int n = a.length;
		
		for( int i=0; i<n; i++) 
			if(a[i]!=i)
				return false;
		
		return true;
	}
}
