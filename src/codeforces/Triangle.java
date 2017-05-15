package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class Triangle {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] lines = new int[n];
		for(int i=0; i<n; i++)
			lines[i] = in.nextInt();
		Arrays.sort(lines);
		for(int i=0; i<n-2; i++){
			if(canTriangleForm(lines[i], lines[i+1], lines[i+2])){
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}
	
	static boolean canTriangleForm(int a, int b, int c){
		if(a+b>c && b+c>a && a+c>b)
			return true;
		return false;
		
	}
}
