package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class TheQueue767B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long ts = in.nextLong();
		long tf = in.nextLong();
		long t = in.nextLong();
		int n = in.nextInt();
		long[] vt = new long[n];
		long[] pro = new long[n];
		for(int i=0; i<n; i++)
			vt[i] = in.nextLong();
		long tvas = ts;
		long min = Long.MAX_VALUE;
		Arrays.sort(vt);
		if(n>0)
			tvas = vt[0]-1;
		
		if(n>0 && vt[0]<ts){
			pro[0] = ts;
			min = Math.abs(vt[0]-1-ts);
		}
		else if(n>0){
			pro[0] = vt[0];
			min = Math.abs(vt[0]-1-ts);
		}
		
		for(int i=1; i<n; i++)
			pro[i] = Math.max(pro[i-1]+t, vt[i]);
		
		//System.out.println(Arrays.toString(pro));
		
		for(int i=0; i<n-1; i++){
			long temp = Math.abs(vt[i+1]-1-(pro[i]+t));
			
			if(temp <= min){
				min = temp;
				tvas = vt[i+1]-1;
			}
		}
		//System.out.println(min);
		if(n>0 && min !=0 && pro[n-1]+2*t <= tf){
			tvas = pro[n-1]+t;
		}
		
		System.out.println(tvas);
		
		
	}
}
