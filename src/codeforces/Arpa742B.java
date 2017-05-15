package codeforces;

import java.util.Scanner;

public class Arpa742B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int x = in.nextInt();
		int[] a = new int[100001];
		for(int i=0; i<n; i++){
			a[in.nextInt()]++;
		}
		long pairs = 0;
		//int pair0 = 0;
		for(int i=0; i<100001; i++){
			int num = 0;
			int tf = i^x;
			if((tf<100001 & tf>=0)){
				num = (a[tf]*a[i])/2;
				pairs+=num;
			}
			else if(a[i]>0&tf==0&(tf<100001&tf>=0)){
				num = (a[tf]*a[i]);
				pairs+=num;
			}
		}
		System.out.println(pairs);
	}
}
