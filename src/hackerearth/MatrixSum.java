package hackerearth;

import java.util.Scanner;

public class MatrixSum {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n  = in.nextInt();
		int m = in.nextInt();
		
		int[][] mat = new int[n][m];
		
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++)
				mat[i][j] = in.nextInt();
		}
		
		int[][] sum = new int[n][m];
		
		calcSum(mat, sum, n, m);
		
		
		int q = in.nextInt();
		
		for(int i=0; i<q; i++){
			int x = in.nextInt();
			int y = in.nextInt();
			System.out.println(sum[x-1][y-1]);
		}
		
	}
	
	
	static void calcSum(int[][] mat, int[][] sum, int n, int m){
		
		sum[0][0] = mat[0][0];		
		for(int i=1; i<n; i++)
			sum[i][0] = sum[i-1][0] + mat[i][0];
		
		for(int i=1; i<m; i++)
			sum[0][i] = sum[0][i-1] + mat[0][i];
		
		for(int i=1; i<n; i++){
			for(int j=1; j<m; j++){
				sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+mat[i][j];
			}
		}
		
		//print
		/*StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				sb.append(sum[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());*/
	}
}
