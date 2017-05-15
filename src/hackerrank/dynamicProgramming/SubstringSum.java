package hackerrank.dynamicProgramming;

import java.util.Scanner;

public class SubstringSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++)
			arr[i] = in.nextInt();
		
		int[] sum = new int[n];
		sum[0] = arr[0];
		
		for(int i=1; i<n; i++)
			sum[i] = sum[i-1]+arr[i];
		
		
		
		int ans = 0;
		
		for(int i=0; i<n-1; i++){
			for(int j=i+1; j<n; j++){
				//System.out.println("("+i+", "+j+")  " +(sumRange(sum, 0, i-1)+2*sumRange(sum, i, j)+sumRange(sum, j+1, n-1)));
				ans += sumRange(sum, 0, i-1)+(j-i+1)*sumRange(sum, i, j)+sumRange(sum, j+1, n-1);
			}
		}
		ans+=sum[n-1];
		System.out.println(+ans);
		
		
		
	}
	
	public static int sumRange(int[] sum, int i, int j){
		if(i>j)
			return 0;
		if(i==0)
			return sum[j];
		return sum[j]-sum[i-1];
		
	}
}
