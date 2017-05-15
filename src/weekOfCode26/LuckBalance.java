package weekOfCode26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/luck-balance
 * All Domains  Algorithms  Greedy  Luck Balance
 */
public class LuckBalance {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int luck = 0;
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++){
			int l = in.nextInt();
			int imp = in.nextInt();
			if(imp==0)
				luck+=l;
			
			else{
				list.add(l);
			}
		}
		int[] arr = new int[list.size()];

		for(int i=0; i<arr.length; i++){
			arr[i] = list.get(i);
		}
		Arrays.sort(arr);
		
		int i=1;
		int rr = k;
		if(arr.length>0){
			
			rr = Math.min(k, arr.length);
			while(rr>0){
				
				luck += arr[arr.length-i];
				arr[arr.length-i] = 0;
				i++;
				rr--;
			}
			
			for(i= 0; i<arr.length; i++){
				luck -= arr[i];
			}
		}
		System.out.println(luck);
		
	}
}
