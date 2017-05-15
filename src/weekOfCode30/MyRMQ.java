package weekOfCode30;

import java.util.Arrays;
import java.util.Scanner;

public class MyRMQ {
	
	static final int S = 200;
	static int[][][] tableBS;
	static int[][] tableAS;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		
		StringBuilder ans = new StringBuilder();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++)
			arr[i] = in.nextInt();
			
		
		
		preCompute(arr);
		
		
		for(int j=0; j<q; j++){
			
			int l = in.nextInt();
			int r = in.nextInt()+1;
			int x = in.nextInt();
			int y = in.nextInt();
			
			
			if(x<=200) {
				ans.append(lowerBound(tableBS[x][y], r)-lowerBound(tableBS[x][y], l)+"\n");
				
			}
			
			
			else {
				int rslt = 0;
				for(int i=y; i<40001; i+=x){
					rslt += lowerBound(tableAS[i], r)-lowerBound(tableAS[i], l);
				}
				ans.append(rslt+"\n");
			}
		}
		
		
		System.out.println(ans);
		
		
	}
	
	
	static int lowerBound(int[] arr, int key){
		
		int high = arr.length;
		int low = -1;
		
		int mid;
		
		while(high-low > 1) {
			mid = (low+high)/2;
			if(arr[mid]>=key)
				high = mid;
			else
				low = mid;
		}
		
		return high;
	}
	
	
	static void preCompute(int[] arr) {
		
		int n = arr.length;
		tableBS = new int[S+1][][];
		
		for(int m=1; m<=S; m++) {
			
			int[] modArr = new int[n];
			
			for(int i=0; i<n; i++) {	
				modArr[i] = arr[i]%m;
			}
			
			tableBS[m] = makeTableForBelowS(modArr, m);
			
		}
		
		tableAS = makeTableForAboveS(arr);
		
	}
	
	static int[][] makeTableForBelowS(int[] modArr, int m) {
		
		int n = modArr.length;
		int[][] g = new int[m][];
		int[] cntModArr = new int[m];
		
		
		for(int i=0; i<n; i++)
			cntModArr[modArr[i]]++;
		
		
		for(int i=0; i<m; i++)
			g[i] = new int[cntModArr[i]];
			
		for(int i=n-1; i>=0; i--)
			g[modArr[i]][--cntModArr[modArr[i]]] = i;
		
		return g;
		
	}
	
	
	static int[][] makeTableForAboveS(int[] arr){
		
		int n = arr.length;
		
		int[] cnt = new int[40001];
		
		for(int i=0; i<n; i++)
			cnt[arr[i]]++;
		
		int[][] table = new int[40001][];
		
		for(int i=0; i<40001; i++)
			table[i] = new int[cnt[i]];
		
		for(int i=n-1; i>=0; i--)
			table[arr[i]][--cnt[arr[i]]] = i;
		
		return table;
		
	}
	
	
}
