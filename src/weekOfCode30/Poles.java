package weekOfCode30;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Poles {
	
	static long min = Long.MAX_VALUE;
	static long[][][] map;
	static long[][] mapUtil;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		map = new long[n][n][k+1];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				Arrays.fill(map[i][j], Long.MAX_VALUE);
			}
		}
		
		mapUtil = new long[n][n+1];
		int[][] wx = new int[n][2];
		for(int i=0; i<n; i++){
			wx[i][0] = in.nextInt();
			wx[i][1] = in.nextInt();
		}
		//double start = System.nanoTime();
		gen(wx, n);
		System.out.println(f(wx, 0, n-1, k));
		//System.out.println(i+" "+(System.nanoTime()-start)/1000000+" ms");
	}
	
	static long f(int[][] wx, int low, int high, int k){
		if(map[high][low][k]!=Long.MAX_VALUE){
			return map[high][low][k];
		}
		
		if(k==1)
			return g(high, low);
		
		for(int i=low; i<=high-k+1; i++){
			min = Math.min(min, g(i, low) + f(wx, i+1, high, k-1));
		}
		
		map[high][low][k] = min;
		
		return min;
	}
	
	static long g(int high, int low){
		long ans = 0;
		for(int i=high; i>=low; i--)
			ans += (mapUtil[i][low]-mapUtil[i][low+1]);
		return ans;
	}
	
	static void gen(int[][] wx, int n){
		for(int i=0; i<n; i++){
			for(int j=i; j>=0; j--){
				mapUtil[i][j] = mapUtil[i][j+1] + (wx[i][0]-wx[j][0])*wx[i][1];
			}
		}	
	}
	
}
