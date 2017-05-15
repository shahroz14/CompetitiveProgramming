package mathematics;

import java.util.Scanner;

public class NCr {
	static final int MOD = 1000000000;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder sb= new StringBuilder("");
		int[][] tab = generateNCrTable(1000);
		for(int i=0; i<t; i++){
			int n = in.nextInt();
			for(int j=0; j<=n; j++){
				sb.append(tab[n][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int[][] generateNCrTable(int n){
		if(n<1)
			return null;
		int[][] t = new int[n+1][n+1];
		t[1][0] = 1;
		t[1][1] = 1;
		for(int i=2; i<=n; i++){
			for(int j=0; j<=i; j++){
				if(j==0||j==i){
					t[i][j] = 1;
					continue;
				}
				t[i][j] = (t[i-1][j-1]+t[i-1][j])%MOD;
			}
		}
		return t;
	}
	
	static void printTable(int[][] t){
		int n = t.length;
		for(int i=1; i<n; i++){
			for(int j=0; j<=i; j++){
				System.out.print(t[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
