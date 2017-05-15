package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pairs {
	/*
	 * https://www.hackerrank.com/challenges/pairs
	 * All Domains  Algorithms  Search  Pairs
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().trim().split(" ");
		
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		
		line = br.readLine().trim().split(" ");
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(line[i]);
		
		Arrays.sort(arr);
		
		int cnt = 0;
		
		for(int i=0; i<n-1; i++){
			for(int j=i+1; j<n; j++){
				if(arr[j]-arr[i]==k)
					cnt++;
				if(arr[j]-arr[i]>k)
					break;
			}
		}
		System.out.println(cnt);
	}
}
