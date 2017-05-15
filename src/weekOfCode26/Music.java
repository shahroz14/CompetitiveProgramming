package weekOfCode26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Music {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		
		int[] arr = new int[n];
		String[] line = br.readLine().trim().split(" ");
		
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(line[i]);
		
		line = br.readLine().trim().split(" ");
		
		int m = Integer.parseInt(line[0]);
		int h1 = Integer.parseInt(line[1]);
		int h2 = Integer.parseInt(line[2]);
		int start = 0;
		boolean ch = false;
		int cov = h1;
		int i;
		for(i=n-1; i>0; i--){
			if(arr[i]-arr[i-1]>h2){
				start = arr[i]-h2;
				System.out.println(start);
				return;
			}
			if(arr[i]-arr[i-1]<h1){
				start = arr[i];
				System.out.println(start);
				return;
			}
			cov += arr[i]-arr[i-1];
			if(cov>m){
				cov = cov - (arr[i]-arr[i-1]);
				start = arr[i]-(m-cov);
				if(arr[i]-start<h1)
					start = arr[i];
				System.out.println(start);
				return;
			}
		}
		if(m-cov>h2)
			start = arr[0]-h2;
		else
			start = arr[0]-(m-cov);
		
		System.out.println(start);
			
	}
}
