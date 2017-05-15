package hack45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChoosenOne {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		long[] a = new long[n];
		
		for(int i=0; i<n; i++){
			a[i] = in.nextLong();
		}
		//Arrays.sort(a);
		//System.out.println(Arrays.toString(a));
		if(n==1){
			System.out.println(a[0]+1);
			return;
		}
		
		
		long[] preGCD = new long[n];
		long[] sufGCD = new long[n];
		
		preGCD[0] = a[0];
		sufGCD[n-1] = a[n-1];
		for(int i=1; i<n; i++){
			preGCD[i] = GCD(preGCD[i-1], a[i]);
			sufGCD[n-i-1] = GCD(sufGCD[n-i], a[n-i-1]);
		}
		System.out.println("Prefix  "+Arrays.toString(preGCD));
		System.out.println("Suffix  "+Arrays.toString(sufGCD));
		
		long temp;
		for(int i=0; i<n-1; i++){
			if(i==0)
				temp = sufGCD[1];
			else if(i==n-1)
				temp = preGCD[n-2];
			else
				temp = GCD(preGCD[i-1], sufGCD[i+1]);
			System.out.println(temp+"  temp");
			if((a[i]%temp)!=0){
				System.out.println(temp);
				return;
			}
		}
			//System.out.println(a[1]);
	}
	
	static long GCD(long a, long b){
		if(b==0)
			return a;
		return GCD(b, a%b);
	}
}
