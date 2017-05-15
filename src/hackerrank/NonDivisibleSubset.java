package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.hackerrank.com/challenges/non-divisible-subset
 * All Domains/Algorithms/Implementation/Non-Divisible Subset
 */
public class NonDivisibleSubset {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		line = br.readLine().split(" ");
		
		int[] a = new int[n];
		int[] rem = new int[k];
		
		for(int i=0; i<n; i++){
			a[i] = Integer.parseInt(line[i]);
			rem[a[i]%k]++;
		}
		
		int count = 0;
		
		if(k%2==1){
			for(int i=1; i<=k/2; i++){
				count += Math.max(rem[i], rem[k-i]);
			}
			if(rem[0]>0){
				count++;
			}
		}
		else{
			for(int i=1; i<k/2; i++){
				count += Math.max(rem[i], rem[k-i]);
			}
			if(rem[0]>0)
				count++;
			if(rem[k/2]>0)
				count++;
		}
		
		System.out.println(count);
		
	}
}
